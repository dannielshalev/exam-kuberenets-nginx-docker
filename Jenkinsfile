def registry = "7879/exam-webserver"
def registryCredential = 'guitar'
pipeline {
    agent any
    stages {
        stage('Building image') {
            steps{
                script {
                    sh "bash update_website.sh $BUILD_NUMBER"
                    def dockerfile = 'Dockerfile'
                    def customImage = docker.build("7879/exam-webserver:${env.BUILD_ID}", "-f ${dockerfile} ./dockerfiles")
                    customImage.push()
                }
            }
        }
    }
}


