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
         stage('build docker image') {
            steps {
              sh '''/bin/bash
                  set -e
                  bash update_website.sh $BUILD_NUMBER
                  docker login -u ${DOKERHUB_USR} -p ${DOKERHUB_PSW}
                  docker build -t ${DOKERHUB_USR}/exam-webserver:$BUILD_NUMBER .
                  docker push ${DOKERHUB_USR}:exam-webserver:$BUILD_NUMBER
                  '''
            }
        }
    }
}


