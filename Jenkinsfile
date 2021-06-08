pipeline {
  agent any
    stages {
        stage('build docker image') {
            steps {
              cleanWs()
              checkout scm
              sh '''/bin/bash
                  set -e
                  echo $BUILD_NUMBER
                  bash update_website.sh $BUILD_NUMBER
                  cat index.html
                  docker build -t exam-webserver:$BUILD_NUMBER .
                  '''
            }
        }
        stage('Upload docker image') {
            steps {
              sh '''/bin/bash
                  set -e
                  docker login -u 7879 -p guitar
                  docker container commit exam-webserver:$BUILD_NUMBER
                  docker tag exam-webserver:$BUILD_NUMBER 7879/exam-webserver:$BUILD_NUMBER
                  docker push exam-webserver:$BUILD_NUMBER
                  '''
            }
        }
        stage('deployment') {
            steps {
              withCredentials([string(credentialsId: 'kubeconfig', variable: 'kubeconfig')]){
                sh '''/bin/bash
                    set -e
                    echo $kubeconfig > .kubeconfig
                    export KUBECONFIG=.kubeconfig
                    kubectl apply .
                    '''
                }
            }
        }
    }
}
