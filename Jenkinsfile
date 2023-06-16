
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
                
                appCenter apiToken: '217caf85fbff3e296f13193668abe03a92eb0eb1',
                          appName:  'Trial',
                          pathToApp: '**/*.apk',
                          distributionGroups: 'group2',
                          ownerName: 'nitheeshks91'  
            }
        }

    }
}
