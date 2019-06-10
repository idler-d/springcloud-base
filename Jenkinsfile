pipeline {
  agent any

  def mvnHome = tool 'v3.3.9'
  env.PATH = "${mvnHome}/bin:${env.PATH}"

    stage('mvn test'){
        //mvn 测试
        sh "mvn test"
    }

  stages {
    stage('build project') {
      steps {
        sh 'mvn -DskipTests clean package'
      }
    }
  }
}