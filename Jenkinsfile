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
        stage('Unit test') {
            steps {
                bat 'mvn test'
            }
        }
        stage('Code coverage') {
            steps {
                // Run tests with JaCoCo agent
                sh "mvn clean test"

                // Generate JaCoCo coverage report
                sh "mvn jacoco:report"

                // Enforce coverage verification rules
                sh "mvn jacoco:check"
            }
        }

    }
}
