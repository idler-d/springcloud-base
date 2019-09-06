pipeline {
  agent any
  stages {
    stage('mvn test') {
      steps {
        sh 'mvn --version'
      }
    }
    stage('build project') {
      steps {
        sh 'mvn clean package -Dmaven.test.skip=true'
      }
    }
  }
  tools {
    maven 'v3.3.9'
  }
  environment {
    DOCKER_HOST = 'tcp://192.168.120.13:2375'
  }
}