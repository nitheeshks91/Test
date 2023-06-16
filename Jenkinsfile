
pipeline {
    agent any

    stages {
       // stage('Checkout') {
     //       steps {
                // Checkout the source code from your version control system
                // For example, if using Git:
       //         git 'https://github.com/your-repo-url.git'
       //     }
      //  }

        stage('Build') {
            steps {
                // Set up the Android SDK and tools
                // You might need to adjust the paths based on your system configuration
                //tool 'Android_SDK'

                echo "$ANDROID_SDK"

                echo "branch name $BRANCH"
                
                 echo "variant $BUILD"
                
                 echo "build variente $env.BUILD"
                
                sh 'chmod +x gradlew'
                // Build the Android project
                sh './gradlew assembleDebug'
            }
        }

        stage('Run Tests') {
            steps {
                // Run the unit tests, instrumented tests, or any other tests
                // Adjust the command based on your test suite
                sh './gradlew test'
            }
        }

        stage('Generate APK') {
            steps {
                // Generate the APK file
                sh './gradlew assembleDebug'
                archiveArtifacts artifacts: '**/*.apk', fingerprint: true
            }
        }

    }
}
