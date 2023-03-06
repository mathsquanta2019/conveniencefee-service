FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY target/cfs.jar .

EXPOSE 9090

ENTRYPOINT ["java", "-jar", "cfs.jar"]