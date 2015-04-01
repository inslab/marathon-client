package mesosphere.marathon.client.model.v2;

import java.util.List;

import mesosphere.marathon.client.utils.ModelUtils;

public class Subscription {

	private List<String> callbackUrls;

	public List<String> getCallbackUrls() {
		return callbackUrls;
	}

	public void setCallbackUrls(List<String> callbackUrls) {
		this.callbackUrls = callbackUrls;
	}

	@Override
	public String toString() {
		return ModelUtils.toString(this);
	}
}
