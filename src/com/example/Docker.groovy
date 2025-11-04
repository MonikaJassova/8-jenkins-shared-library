#!/user/bin/env groovy
package com.example

class Docker implements Serializable {

    def script

    Docker(script) {
        this.script = script
    }

    def buildDockerImage(String imageName) {
        script.echo "building the docker image..."
        script.sh "docker build -t $imageName ."
    }

    def dockerLogin() {
        script.withCredentials([script.usernamePassword(credentialsId: 'nexus', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
            script.sh "echo '${script.PASS}' | docker login -u '${script.USER}' --password-stdin 104.248.35.74:8083"
        }
    }

    def dockerPush(String imageName) {
        script.sh "docker push $imageName"
    }

    def deployCompose(String imageName, String ec2) {
        script.echo "Deploying the application..."
        def shellCmd = "bash ./server-cmds.sh $imageName"
 
        script.sshagent(['ec2-server-key']) {
            script.sh "scp server-cmds.sh ${ec2}:/home/ec2-user"
            script.sh "scp docker-compose.yaml ${ec2}:/home/ec2-user"
            script.sh "ssh -o StrictHostKeyChecking=no ${ec2} ${shellCmd}"
        } 
    }
}