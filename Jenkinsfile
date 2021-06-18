def registry = "7879/exam-webserver"

def registryCredential = 'guitar'

def dockerHome = tool 'myDocker'

def build_image(String build) {
    def dockerfile = 'Dockerfile'
    def customImage = docker.build("7879/exam-webserver:${build}", "-f ${dockerfile} ./dockerfiles")
    customImage.push()
}

pipeline {
    agent any
    stages {
        stage('Building image') {
            steps{
                script {
//                    env.PATH = "${dockerHome}/bin:${env.PATH}"
                    sh "bash update_website.sh $BUILD_NUMBER"
                    sh "curl -fsSLO https://get.docker.com/builds/Linux/x86_64/docker-17.04.0-ce.tgz \
                        && tar xzvf docker-17.04.0-ce.tgz \
                        && mv docker/docker /usr/local/bin \
                        && rm -r docker docker-17.04.0-ce.tgz"
                    build_image("$BUILD_NUMBER")
                }
            }
        }
    }
}


