pipeline {
    agent any

    stages {
        stage('Environment Setup') {
            steps {
                git credentialsId: '12922d56-43f2-48f5-bd00-8ac0a72fbbf7', url: 'https://github.com/kapilbande/FlipkartUIAndAPITest.git'
                bat script: 'mvn clean install -DskipTests'
            }
        }
        stage('Build') {
            steps {
               bat script: 'mvn compile'
            }
        }
        stage('Test') {
            steps {
                bat script: 'mvn test'
            }
        }
        stage('Release') {
            steps {
                echo 'Release tasks'
            }
        }
    }
}
