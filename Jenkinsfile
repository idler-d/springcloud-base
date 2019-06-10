pipeline {
  agent any
  stages {
    stage('build project') {
      steps {
        sh 'mvn -DskipTests clean package'
      }
    }
  }
}