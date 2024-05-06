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
	    parallel {
		stage('Test Suite 1') {

            	steps {
                bat script: 'mvn test -DsuiteXmlFile=testng.xml'
           	      }
        	}
		stage('Test Suite 2') {

            	steps {
                bat script: 'mvn test -DsuiteXmlFile=testng1.xml'
           	      }
        	}
			}
			}
        stage('Release') {
            steps {
                echo 'Release tasks'
            }
        }
    }
}
