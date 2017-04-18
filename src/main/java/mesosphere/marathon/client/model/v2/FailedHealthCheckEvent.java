package mesosphere.marathon.client.model.v2;

public class FailedHealthCheckEvent extends Event {

	private HealthCheck healthCheck;

	public HealthCheck getHealthCheck() {
		return healthCheck;
	}

	public void setHealthCheck(HealthCheck healthCheck) {
		this.healthCheck = healthCheck;
	}
}
