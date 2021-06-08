pipeline {
    stages {
        stage('build') {
            steps {
                #!/bin/bash'''
                  echo $BUILD_NUMBER
                  sh 'bash update_website.sh $BUILD_NUMBER
                  '''
            }
        }
    }
}
