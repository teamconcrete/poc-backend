pipeline {
    agent any
    stages{
     
         stage( "Checkout"){
            steps{
                git url: 'https://github.com/teamconcrete/poc-backend.git', branch: 'develop'
            }

         }

         stage("Build"){
            steps{ 
              sh "gradle wrapper && gradle build --stacktrace"
              archiveArtifacts artifacts: '**/build/libs/*.jar', fingerprint: true
              
            }
         }
         stage('Publish') {
            nexusPublisher nexusInstanceId: 'localNexus', nexusRepositoryId: 'releases', packages: [[$class: 'MavenPackage', mavenAssetList: [[classifier: '', extension: '', filePath: '**/build/libs/*.jar']], mavenCoordinate: [artifactId: 'jenkins-jar', groupId: 'org.jenkins-ci.main', packaging: 'jar', version: '1.0']]]
         }
        
        stage('Send Message') {
            when {
              expression {
                currentBuild.result == null || currentBuild.result == 'SUCCESS' 
              }
            }
            steps {
               echo 'Sucesso'
               slackSend channel: "#devops-onboarding",color: '#0000FF', message: "Build Started: ${env.JOB_NAME} ${env.BUILD_NUMBER}"
            }
            
        }
    }    

      
}
