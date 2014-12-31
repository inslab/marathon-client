package mesosphere.marathon.client.model.v2;

import java.util.Collection;
import java.util.Map;

import mesosphere.marathon.client.utils.ModelUtils;

public class Docker {
	private String image;
	private String network;
	private Map<String, String> parameters;
	private Collection<Port> portMappings;

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getNetwork() {
		return network;
	}

	public void setNetwork(String network) {
		this.network = network;
	}

	public Collection<Port> getPortMappings() {
		return portMappings;
	}

	public void setPortMappings(Collection<Port> portMappings) {
		this.portMappings = portMappings;
	}
	
	public Map<String, String> getParameters() {
		return parameters;
	}

	public void setParameters(Map<String, String> parameters) {
		this.parameters = parameters;
	}
	
	@Override
	public String toString() {
		return ModelUtils.toString(this);
	}
}
