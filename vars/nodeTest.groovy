#!/user/bin/env groovy

def call() {
    echo "Running tests..."
    sh 'npm test'
}
