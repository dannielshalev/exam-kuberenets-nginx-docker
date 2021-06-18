pipeline {
    agent any
    def registry = "7879/exam-webserver"
    def registryCredential = 'guitar'
    stages {
        stage('Building image') {
            steps{
                script {
                    sh "update_website.sh $BUILD_NUMBER"
                    docker.build registry + ":$BUILD_NUMBER"
                }
            }
        }
    }
}


