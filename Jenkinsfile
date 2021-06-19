//def registry = "7879/exam-webserver"
//
//def registryCredential = 'guitar'
//


def build_image(String build) {
    def dockerfile = 'Dockerfile'
    def customImage = docker.build("7879/exam-webserver:${build}", "-f ${dockerfile} $WORKSPACE/")
    customImage.push()
}

pipeline {
    agent any
    environment {
        DOKERHUB = credentials('duckerhub')
    }
    stages {
        stage('Initialize') {
            steps{
                script {
                    def dockerHome = tool 'myDocker'
                    env.PATH = "${dockerHome}/bin:${env.PATH}"
                    }
                }
            }
        stage('Building image') {
            steps {
                script {
                    sh "bash update_website.sh $BUILD_NUMBER"
                    build_image("$BUILD_NUMBER")
                }
            }
        }
    }
}


