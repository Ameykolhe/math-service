  
pipeline {
    agent any

    tools {
        maven 'Maven-3.6.3'
    }

    environment {
        JAR_FILENAME = "math-service"
        JAR_VERSION = "0.0.1-SNAPSHOT"
    }

    stages {
        stage("Test") {
            steps {
                sh "mvn clean test"
            }
        }

        stage("Build") {
            steps {
                sh "mvn package -DskipTests"
            }
        }

        stage("Execute Main class") {
            steps {
                sh "java -cp target/${JAR_FILENAME}-${JAR_VERSION}.jar com.sapient.Main isPrime 20"
            }
        }
    }
    post {
        always {
            echo "This will always be executed"
        }
        success {
            echo "This will be executed only when all stages succeed"
            junit '**/*xml'
            jacoco()
            archiveArtifacts artifacts: "target/${JAR_FILENAME}-${JAR_VERSION}.jar", followSymlinks: false
            deleteDir()
        }
        failure {
            echo "This will be executed whenever any stage fails"
        }
    }
}