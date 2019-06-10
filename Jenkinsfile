pipeline {
  agent any
  stages {
    stage('build project') {
      steps {
        build 'build'
      }
    }
    stage('docker-pro') {
      parallel {
        stage('docker-pro') {
          steps {
            sh 'ls'
          }
        }
        stage('docker-test') {
          steps {
            sh 'ls'
          }
        }
      }
    }
    stage('docker-deploy') {
      steps {
        sh 'ls'
      }
    }
  }
}