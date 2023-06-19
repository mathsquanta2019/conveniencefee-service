FROM maven:3.8.1-openjdk-17-slim AS build

COPY . .

RUN mvn clean install -DskipTests

FROM openjdk:17-jdk-alpine

COPY --from=build /target/cfs.jar cfs.jar

EXPOSE 9090

ENTRYPOINT ["java", "-jar", "cfs.jar"]