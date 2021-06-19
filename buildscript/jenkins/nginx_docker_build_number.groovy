pipelineJob("nginx_docker_build_number") {
	description()
	keepDependencies(false)
	definition {
		cpsScm {
			scm {
				git {
					remote {
						github("dannielshalev/exam-kuberenets-nginx-docker", "https")
					}
					branch("*/main")
				}
			}
			scriptPath("Jenkinsfile")
		}
	}
	disabled(false)
	configure {
		it / 'properties' / 'com.coravy.hudson.plugins.github.GithubProjectProperty' {
			'projectUrl'('https://github.com/dannielshalev/exam-kuberenets-nginx-docker/')
			displayName()
		}
	}
}