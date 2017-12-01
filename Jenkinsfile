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
              sh "gradle clean assemble && gradle wrapper  && gradle build --stacktrace"
              archiveArtifacts artifacts: '**/build/libs/*.jar', fingerprint: true
              
            }
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
