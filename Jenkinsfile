
pipeline {
    agent any

    stages {

        stage('Generate APK') {
            steps {
                echo "${env.APP}"
                echo "$BUILD"
                sh 'chmod +x gradlew'
                  sh "./gradlew assembleCompany${env.BUILD}Debug"
                archiveArtifacts artifacts: '**/*.apk', fingerprint: true
            }
        }

        stage('Publish') {
            steps {
                // Generate the APK file
                
                appCenter apiToken: '217caf85fbff3e296f13193668abe03a92eb0eb1',
                          appName:  'Trial',
                          pathToApp: '**/*.apk',
                          distributionGroups: 'group2',
                          ownerName: 'nitheeshks'  
            }
        }

    }
}
