pipeline {
  agent any

  stages {
    stage('Build') {
      steps {
        bat 'mvn clean package'
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
          bat 'mvn clean sonar:sonar'
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
