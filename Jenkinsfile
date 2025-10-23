pipeline {
    agent any

    stages {
        stage("Checkout") {
            steps {
                git branch: 'main', url: 'https://github.com/emannnx/Calculator.git'
            }
        }

        stage("Compile") {
            steps {
                bat "mvn clean compile"
            }
        }

        stage("Unit Test & Code Coverage") {
            steps {
                // Run tests and collect coverage
                bat "mvn clean test jacoco:report"

                // Publish JaCoCo HTML report to Jenkins
                publishHTML(target: [
                    reportDir: 'target/site/jacoco',
                    reportFiles: 'index.html',
                    reportName: 'JaCoCo Code Coverage Report'
                ])

                // Enforce coverage rules
                bat "mvn jacoco:check"
            }
        }
    }

    post {
        always {
            echo "Cleaning up workspace..."
            cleanWs()
        }
        success {
            echo "✅ Build, test, and coverage successful!"
        }
        failure {
            echo "❌ Build or tests failed!"
        }
    }
}
