pipeline {
  agent any
  tools {
      //工具名称必须在Jenkins 管理Jenkins → 全局工具配置中预配置。
      maven 'v3.3.9'
  }
  stages {
    stage('mvn test'){
        steps {
          //mvn 测试
          sh 'mvn --version'
        }
    }
    stage('build project') {
      steps {
        sh 'mvn clean package -Dmaven.test.skip=true'
      }
    }
  }
}