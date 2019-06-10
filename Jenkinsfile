pipeline {
  agent any

  tools {
      //工具名称必须在Jenkins 管理Jenkins → 全局工具配置中预配置。
      maven 'v3.3.9'
  }

    stage('mvn test'){
        //mvn 测试
        sh "mvn --version"
    }

  stages {
    stage('build project') {
      steps {
        sh 'mvn -DskipTests clean package'
      }
    }
  }
}