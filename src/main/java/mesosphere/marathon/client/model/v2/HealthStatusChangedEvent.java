package mesosphere.marathon.client.model.v2;

public class HealthStatusChangedEvent extends Event {

	private String version;
	private boolean alive;

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}
}
