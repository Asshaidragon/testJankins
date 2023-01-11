#!groovy

properties([disableConcurrentBuilds()])

pipeline {
    agent {
        label 'built-in'
    }
    options{
        buildDiscarder(logRotator(numToKeepStr: '10', artifactNumToKeepStr: '10'))
        timestamps()
    }
    stages {
        stage('Build') {
            steps {
                echo "================ start building images ================"
                    sh 'docker build -t jenkins_build_test -f build/Dockerfile .'
            }
        }
        stage('Run test') {
            steps {
                echo "================ Run tests ================"
                    sh 'docker run --rm jenkins_build_test pytest test/'
            }
        }
    }
}