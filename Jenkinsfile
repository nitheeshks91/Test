
pipeline {
    agent any

    stages {

        stage('Build') {
            steps {
                // Set up the Android SDK and tools
                // You might need to adjust the paths based on your system configuration
                //tool 'Android_SDK'

                echo "branch name $BRANCH"
                
                 echo "variant $BUILD"
                
                 echo "build variente $env.BUILD"
                
                sh 'chmod +x gradlew'
                // Build the Android project
                sh './gradlew assembleDebug'
            }
        }


        stage('Generate APK') {
            steps {
                // Generate the APK file
                sh './gradlew assembleDebug'
                archiveArtifacts artifacts: '**/*.apk', fingerprint: true
            }
        }

        stage('Publish') {
            steps {
                // Generate the APK file
                
                appCenter apiToken: '2610c689b3453a2c2b57d1b5ba54d256853d0114',
                          appName:  'Trial',
                          pathToApp: '**/*.apk',
                          distributionGroups: 'group2',
                          ownerName: 'nitheeshks91'  
            }
        }

    }
}
