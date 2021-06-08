pipeline {
  agent any
    stages {
        stage('build') {
            steps {
              cleanWs()
              checkout scm
              sh '''/bin/bash
                  set -e
                  echo $BUILD_NUMBER
                  sh 'bash update_website.sh $BUILD_NUMBER
                  '''
            }
        }
    }
}
