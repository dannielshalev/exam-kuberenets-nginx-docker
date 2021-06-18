def registry = "7879/exam-webserver"
def registryCredential = 'guitar'
pipeline {
    agent any
    stages {
        stage('Building image') {
            steps{
                script {
                    sh "bash update_website.sh $BUILD_NUMBER"
                    sh "cat index.html"
                    docker.build registry + ":$BUILD_NUMBER"
                }
            }
        }
    }
}


