pipeline {
  agent any
    stages {
        stage('build docker image') {
            steps {
              cleanWs()
              checkout scm
              sh '''/bin/bash
                  set -e
                  bash update_website.sh $BUILD_NUMBER
                  docker login -u 7879 -p guitar
                  sudo docker build -t 7879/exam-webserver:$BUILD_NUMBER .
                  docker push 7879:exam-webserver:$BUILD_NUMBER
                  '''
            }
        }
        stage('deployment') {
            steps {
              withCredentials([string(credentialsId: 'kubeconfig', variable: 'kubeconfig')]){
                sh '''/bin/bash
                    set -e
                    echo $ARTIFACTORY_PASS > .kubeconfig
                    export KUBECONFIG=.kubeconfig
                    helm install danniel-app
                    '''
                }
            }
        }
    }
}
