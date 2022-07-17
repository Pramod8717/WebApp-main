pipeline
{
	 agent any
	 tools {
	 maven 'Maven'
	 }
	
	stages
	{
			stage('Run the command')
			{
				steps
				{
					echo 'Run the Command'
					bat "mvn --version"
					echo "TimeStamp: ${currentBuild.startTimeInMillis}"
				}
			}
			stage('Test')
			{
				steps
				{
					deploy adapters: [tomcat8(credentialsId: 'tomcatserverdetails', path: '', url: 'http://localhost:8087')], contextPath: '/WebApp', war: '**/*.war'
					echo 'Test the Project'
				}
			}
			stage('Deploy to server')
			{
				steps
				{
					deploy adapters: [tomcat8(credentialsId: 'tomcatserverdetails', path: '', url: 'http://localhost:8087')], contextPath: '/WebApp', war: '**/*.war'
					echo 'Deploy on server Project'
				}
			}
			stage('Deploy to Production')
			{
				steps
				{
					echo 'Deploy on Production Project'
				}
			}
		
	}
}
		
		
		
	
