#!/user/bin/env groovy

def call() {
    echo "Installing project dependencies..."
    sh 'npm ci'
}
