def registry = "7879/exam-webserver"

def registryCredential = 'guitar'

def build_image(String build) {
    def dockerfile = 'Dockerfile'
    def customImage = docker.build("7879/exam-webserver:${build}", "-f ${dockerfile} $WORKSPACE/${dockerfile}")
    customImage.push()
}

pipeline {
    agent any
    environment {
        KUBECONFIG = credentials('kubeconfig')
        DOKERHUB = credentials('duckerhub')
    }
    stages {
        stage('Building image') {
            steps{
                    def dockerHome = tool 'myDocker'
                    env.PATH = "${dockerHome}/bin:${env.PATH}"
                    }
                }
        stage('Building image') {
            steps{
              sh '''/bin/bash
                  set -e
                  bash update_website.sh $BUILD_NUMBER
                  docker login -u ${DOKERHUB_USR} -p ${DOKERHUB_PSW}
                  sudo docker build -t ${DOKERHUB_USR}/exam-webserver:$BUILD_NUMBER .
                  docker push ${DOKERHUB_USR}:exam-webserver:$BUILD_NUMBER
                  '''
            }
        }
    }
}



