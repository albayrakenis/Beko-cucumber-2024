pipeline {
    agent any

    tools {
        maven 'Maven_3.9.8' // Jenkins > Global Tool Configuration’da tanımladığın isimle aynı olmalı
    }

    environment {
        MAVEN_HOME = tool 'Maven_3.9.8'
        PATH = "${MAVEN_HOME}/bin:${env.PATH}"
    }

    stages {
        stage('Build & Test') {
            steps {
                sh 'mvn clean test'
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/*.xml'
            emailext (
                to: 'bekos1test@gmail.com',
                subject: "Test Sonucu: ${currentBuild.fullDisplayName}",
                body: """<p>Build sonucu: ${currentBuild.result}</p>
                         <p><a href="${env.BUILD_URL}">Detayları Görüntüle</a></p>""",
                mimeType: 'text/html'
            )
        }
    }
}
