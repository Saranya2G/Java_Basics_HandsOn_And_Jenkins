pipeline{
    agent any
    tools {
        maven "Maven"
    }
       stages{
           stage("Build Maven"){
               steps{
                   checkout scmGit(branches: [[name: '*/spring_boot_crud_mysql']], extensions: [], userRemoteConfigs: [[credentialsId: 'Saranya2G', url: 'https://github.com/Saranya2G/Java_Basics_HandsOn_And_Jenkins.git']])
                   bat "mvn clean install"
               }
           }
           stage("Build Docker Image"){
               steps{
                   script{
                       bat "docker build -t saran0809/demo-devops ."
                   }
               }
           }
           stage("Push Docker Image to hub"){
               steps{
                   script{
                       withCredentials([string(credentialsId: 'docker-pwd', variable: 'dockerpwd')]) {
                          bat "docker login -u saran0809 -p ${dockerpwd}" 
  
                        }
                        bat "docker push saran0809/demo-devops"
                   }
               }
           }
           stage("Stage with input") {
            steps {
              def userInput = false
            script {
                def userInput = input(id: 'Proceed1', message: 'Promote build?', parameters: [[$class: 'BooleanParameterDefinition', defaultValue: true, description: '', name: 'Please confirm you agree with this']])
                echo 'userInput: ' + userInput

                if(userInput == true) {
                echo "Go to next stage"
                } else {
                    bat "docker stop mysqldb"
                       echo "mysqldb container is stopped"
                      bat "docker stop demo-devops"
                       echo "demo-devops container is stopped"
                      bat "docker rm mysqldb"
                       echo "mysqldb container is removed"
                      bat "docker rm demo-devops"
                       echo "demo-devops container is removed"
                echo "Container was aborted."
            }

        }    
    }  
}
           stage("Run Docker Image"){
               steps{
                   script{
                       bat "docker compose up -d"
                       bat "docker compose ps"
                   }
               }
           }
            }   
       }

