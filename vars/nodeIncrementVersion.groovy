#!/user/bin/env groovy

def call() {
    echo "Incrementing version in package.json..."
    sh 'npm --no-git-tag-version version minor'
    def jsonText = readFile 'package.json'
    def json = new groovy.json.JsonSlurper().parseText(jsonText)
    def version = json.version
    env.IMAGE_TAG = "nodejs-$version-$BUILD_NUMBER" // 1.1.0-23 Jenkins build #
}
