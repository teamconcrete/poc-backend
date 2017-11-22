node{
   stage( "Checkout"){

       steps{

           git branch: develop,
               url: "https://github.com/teamconcrete/poc-backend.git"

           sh  "mkdir ../Build/poc-backend
               mv * ../Build/poc-backend"
       }

   }

   stage("Build"){
        sh "cd /var/lib/jenkins/workspace/Build/poc-backend && gradle wrapper"

        archiveArtifacts artifacts: "**/poc-backend/build/test-results/*.xml"

   }

}
