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
        withSonarQubeEnv('SonarQube') {
          sh 'mvn sonar:sonar'
        }
      }
    }

    stage('Dockerize and Push') {
      steps {
        sh 'docker build -t myapp .'
        sh 'docker tag myapp localhost:5000/myapp'
        sh 'docker push localhost:5000/myapp'
      }
    }
  }
}
