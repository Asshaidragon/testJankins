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
                    sh 'docker build -t debug_test_jan -f build/Dockerfile .'
            }
        }
    }
}