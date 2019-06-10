pipeline {
  agent {
    docker {
      image 'maven:3-alpine'
      args '-v /root/.m2:/root/.m2'
    }

  }
  stages {
    stage('build project') {
      steps {
        sh 'mvn -DskipTests clean package'
      }
    }
  }
}