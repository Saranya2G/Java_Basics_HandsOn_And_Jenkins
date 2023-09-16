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
           stage('Check container exsist') {
            steps {
                input message: 'Want to skip the Check container exsist stage?', ok: 'Yes',
                  parameters: [booleanParam(name: 'skip_Check_container_exsist', defaultValue: false)]
                script {
                     echo "started condition"
                     echo "${params.skip_Check_container_exsist.toString().toBoolean()}"
                    if(params.skip_Check_container_exsist.toString().toBoolean()) {
                        echo "inside the condition"
                    bat "docker stop mysqldb"
                       echo "mysqldb container is stopped"
                      bat "docker stop demo-devops"
                       echo "demo-devops container is stopped"
                      bat "docker rm mysqldb"
                       echo "mysqldb container is removed"
                      bat "docker rm demo-devops"
                       echo "demo-devops container is removed"
                        return
                    }
                    
                }
                    echo "already started"
            }
            }   
       }
}
