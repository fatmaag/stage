node {
    
    stage('Clone repo') {
        git branch: "master", url: "https://github.com/fatmaag/stage.git", credentialsId: "fatmaag"
    }
    
    stage('SonarTests') {
        docker.image('test_foqus_sonarqube').inside('-v /var/run/docker.sock:/var/run/docker.sock --entrypoint="" --net jenkins_jenkins') {
            sh "/usr/local/bin/sonar-scanner -Dsonar.host.url=http://172.18.0.1:9000 -Dsonar.projectBaseDir=. -Dsonar.projectKey=Foqus_test "
        }
    }
}
