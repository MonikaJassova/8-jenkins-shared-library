#!/user/bin/env groovy

import com.example.Docker

def call(String imageName, String ec2) {
    return new Docker(this).deployCompose(imageName, ec2)
}