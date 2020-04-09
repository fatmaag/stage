node('docker') {
  stage('SCM') {
    checkout poll: false, scm: [$class: 'GitSCM', branches: [[name: 'refs/heads/develop']], 
    doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], 
    userRemoteConfigs: [[url: 'https://github.com/fatmaag/stage.git']]]
  }
  stage('SonarQube Analysis') {
        sh "/home/jenkins/tools/hudson.plugins.sonar.SonarRunnerInstallation/sonarqubescanner/bin/sonar-scanner -Dsonar.host.url=http://172.18.0.1:9000/ -Dsonar.projectName=Foqus_test -Dsonar.projectVersion=1.0 -Dsonar.projectKey=Foqus_test:app "
    }
  }
