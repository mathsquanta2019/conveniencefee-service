pipeline {
  agent any

  stages {
    stage('Build') {
      steps {
        sh 'mvn clean package'
      }
    }

    stage('Test') {
      steps {
        sh 'mvn test'
      }
    }

    stage('Sonar Scan') {
      steps {
        withSonarQubeEnv(installationName: 'sns1') {
          sh 'mvn clean sonar:sonar'
        }
      }
    }



    stage('Dockerize and Push') {
      steps {
        sh 'docker build -t cfs:2.0.0 .'
      }
    }
  }
}
