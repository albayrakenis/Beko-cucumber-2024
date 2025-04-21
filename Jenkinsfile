// pipeline {
//     agent any
//
//     tools {
//         maven 'Maven' // Buradaki isim, Jenkins’te tanımladığın isimle birebir aynı olmalı!
//     }
//
//     environment {
//         MAVEN_HOME = tool 'Maven'
//         PATH = "${MAVEN_HOME}/bin:${env.PATH}"
//     }
//
//     stages {
//         stage('Build & Test') {
//             steps {
//                 bat 'mvn clean test'
//             }
//         }
//     }
//
//     post {
//         always {
//             junit 'target/surefire-reports/*.xml'
//             emailext (
//                 to: 'bekos1test@gmail.com',
//                 subject: "Test Sonucu: ${currentBuild.fullDisplayName}",
//                 body: """<p>Build sonucu: ${currentBuild.result}</p>
//                          <p><a href="${env.BUILD_URL}">Detayları Görüntüle</a></p>""",
//                 mimeType: 'text/html'
//             )
//         }
//     }
// }
