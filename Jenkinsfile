pipeline {
  agent any
  tools {
    jdk "1.8_212"
    maven "v3.3.9"
  }
  stages {
    stage('build project') {
      steps {
        sh 'mvn -DskipTests clean package'
      }
    }
  }
}