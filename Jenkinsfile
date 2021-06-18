def registry = "7879/exam-webserver"
def registryCredential = 'guitar'
pipeline {
    agent any
    stages {
        stage('Building image') {
            steps{
                script {
                    bash update_website.sh $BUILD_NUMBER"
                    docker.build registry + ":$BUILD_NUMBER"
                }
            }
        }
    }
}


