pipeline {  environment {
    registry = "7879/exam-webserver"
    registryCredential = 'guitar'
  }  agent any  stages {
    stage('Building image') {
      steps{
        script {
          docker.build registry + ":$BUILD_NUMBER"
        }
      }
    }
  }
}
