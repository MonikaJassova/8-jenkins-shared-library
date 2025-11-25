#!/user/bin/env groovy

def call(String repo, String branch) {
    echo "Committing version bump..."
    withCredentials([usernamePassword(credentialsId: 'GitHub', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'git config --global user.email "jenkins@example.com"'
        sh 'git config --global user.name "jenkins"'
        // above needs to be set once - we can also SSH into Jenkins server and set git configuration inside Docker container
        sh 'git status'
        sh 'git branch'
        sh 'git config --list'
        sh "git remote set-url origin https://${USER}:${PASS}@github.com/MonikaJassova/${repo}.git"
        sh 'git add .'
        sh 'git commit -m "ci: version bump"'
        sh "git push origin HEAD:${branch}"
    }
}
