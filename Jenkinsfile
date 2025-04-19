pipeline {
    agent any

    environment {
        MAVEN_HOME = tool 'Maven_3.0.0' // Jenkins'te tanımlı Maven versiyonun ismi
        PATH = "${MAVEN_HOME}/bin:${env.PATH}"
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/albayrakenis/Beko-cucumber-2024.git'
            }
        }

        stage('Testleri Çalıştır') {
            steps {
                sh 'mvn clean test'
            }
        }

        stage('Extent Raporunu Yayınla') {
            steps {
                publishHTML(target: [
                    reportName: 'Extent Report',
                    reportDir: 'test-output/ExtentReport',
                    reportFiles: 'index.html',
                    keepAll: true,
                    alwaysLinkToLastBuild: true,
                    allowMissing: true
                ])
            }
        }

        stage('Raporu Arşivle') {
            steps {
                archiveArtifacts artifacts: 'test-output/**/*.*', fingerprint: true
            }
        }
    }

    post {
        success {
            emailext (
                subject: "✅ Test Başarılı: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: """<p>Testler başarıyla tamamlandı.</p>
                         <p><b>Build:</b> <a href="${env.BUILD_URL}">${env.BUILD_URL}</a></p>
                         <p><b>Extent Raporu:</b> <a href="${env.BUILD_URL}HTML_Report/">Raporu Görüntüle</a></p>""",
                to: "bekos1test@gmail.com",
                mimeType: 'text/html'
            )
        }
        failure {
            emailext (
                subject: "❌ Test Hatalı: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: """<p>Testler sırasında hata oluştu!</p>
                         <p><b>Build:</b> <a href="${env.BUILD_URL}">${env.BUILD_URL}</a></p>
                         <p><b>Extent Raporu (varsa):</b> <a href="${env.BUILD_URL}HTML_Report/">Raporu Görüntüle</a></p>""",
                to: "bekos1test@gmail.com",
                mimeType: 'text/html'
            )
        }
    }
}
