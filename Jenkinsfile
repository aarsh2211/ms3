pipeline {
    agent any
    
    tools {
        maven "maven"
        jdk "Java"
    }

    environment  {

        dockerImage = ''
        registry = 'akshit2707/app'


        //provide credentials in jenkins credentials and tag it as docker_id
        registryCredential = 'docker_id'


    }
    
    stages {

      stage('Cloning Repository'){
          steps{
              git branch: 'dev-backend-pipeline-feature' , url: 'https://tools.publicis.sapient.com/bitbucket/scm/psba/app.git'

              
          }
      }

        stage('Running Tests'){
            steps{
               script{
                   try{
                      sh "mvn test"
                    
                   }
                   catch(error){
                       throw error
                   }
               }
            }
            
        }

    stage('Building Project'){
        steps{
            script{
                 sh "mvn clean org.jacoco:jacoco-maven-plugin:prepare-agent install"
            }
        }
    }

        stage('Analysing Coverage'){
            steps{
                script{

                    withSonarQubeEnv('SonarQube'){
                       sh "mvn sonar:sonar"

                    }
                }
            }
            
        }

        
        
        //Sonar Quality Check

        stage('quality-check'){
            steps {
                  
                script{
                  withSonarQubeEnv('SonarQube'){
                      sh "mvn sonar:sonar"
                  }
                }

            }
        }
        
        
        //Sonar Quality Gate

        stage("Quality gate") {
            steps {
                waitForQualityGate abortPipeline: true
            }
        }

        

       /* 
 // Building Docker images
        stage('Building image to dockerise ') {
            steps{
                script {
                dockerImage = docker.build registry
                }
            }
        }
        
        // Uploading Docker images into Docker Hub   --  define credentials in jenkins
        stage('Uploading Image on dockerhub') {
            steps{    
                script {
                    docker.withRegistry( '', registryCredential ) {
                    dockerImage.push()
                    }
                }
            }
    }
             
*/
    }



    

}
