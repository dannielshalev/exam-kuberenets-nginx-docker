pipeline {
    agent any
    environment {
        registry = "7879/exam-webserver"
        registryCredential = 'guitar'
    }
    stages {
        stage('Building image') {
            steps{
                script {
                    docker.build registry + ":$BUILD_NUMBER"
                }
            }
        }
    }
}
