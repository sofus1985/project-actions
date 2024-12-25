pipeline {
    agent any

    stages {
        stage('get source code') {
            steps {
                git branch: 'main', url: 'git@github.com:sofus1985/project-actions.git'

            }
        }



        stage('build code'){
            steps{
                bat script:  'mvn compile'
            }
        }
        stage('run test'){
            steps{
                bat script: 'mvn test -Dbrowser-localChrome'
            }
        }

        stage('publish report HTML'){
            steps{
                publishHTML([allowMissing: false, alwaysLinkToLastBuild: true, keepAll: true, reportDir: '', reportFiles: 'C:\\Users\\sofiane\\IdeaProjects\\project-actions\\test-output', reportName: 'HTML Report pipeline', reportTitles: '', useWrapperFileDirectly: true])
            }
        }
    }
}