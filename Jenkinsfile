pipeline {
  agent any

  stages {
    stage('Build') {
      steps {
        bat 'mvn clean compile -DskipTests'
      }
    }

    stage('Test') {
      steps {
        bat 'mvn test'
      }
    }

    stage('Sonar Scan') {
      steps {
        withSonarQubeEnv(installationName: 'sns1') {
          bat './mvnw clean org.sonarsource.scanner.maven:sonar-maven-plugin:3.9.1.2184:sonar'
        }
      }
    }



    stage('Dockerize and Push') {
      steps {
        bat 'docker build -t cfs:2.0.0 .'
      }
    }
  }
}
