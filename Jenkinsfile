def registry = "7879/exam-webserver"

def registryCredential = 'guitar'

def build_image(String build) {
    def dockerfile = 'Dockerfile'
    def customImage = docker.build("7879/exam-webserver:${build}", "-f ${dockerfile} ./${dockerfile}")
    customImage.push()
}

pipeline {
    agent any
    stages {
        stage('Building image') {
            steps{
                script {
                    def dockerHome = tool 'myDocker'
                    env.PATH = "${dockerHome}/bin:${env.PATH}"
                    sh "bash update_website.sh $BUILD_NUMBER"
                    sh "ls -ltr"
                    sh "pwd"
                    build_image("$BUILD_NUMBER")
                }
            }
        }
    }
}


