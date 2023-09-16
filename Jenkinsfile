pipeline{
    agent any
    parameters {
        booleanParam(name: 'skip_test', defaultValue: false, description: 'Set to true to skip the test stage')
    }
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
           stage("Removing the docker container"){
               steps{
                   execute_stage('Removing the docker container', params.skip_test) 
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
           def execute_stage(Removing the docker container, skip) {
            stage(Removing the docker container) {
            if(skip) {
            echo "Skipping ${Removing the docker container} stage"
            return
        }
        // Add steps to test the application
    }
}
           
       }
}
