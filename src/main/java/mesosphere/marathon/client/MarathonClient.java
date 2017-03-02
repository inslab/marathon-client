package mesosphere.marathon.client;

import java.util.Iterator;
import java.util.Map;

import feign.Feign;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import feign.Response;
import feign.codec.ErrorDecoder;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import mesosphere.marathon.client.utils.MarathonException;
import mesosphere.marathon.client.utils.ModelUtils;

public class MarathonClient {
	static class MarathonHeadersInterceptor implements RequestInterceptor {
		private Map<String, String> headers;
		
		public MarathonHeadersInterceptor() {
		}
		
		public MarathonHeadersInterceptor(Map<String, String> headers) {
			this.headers = headers;
		}
		
		@Override
		public void apply(RequestTemplate template) {
			template.header("Accept", "application/json");
			template.header("Content-Type", "application/json");
			
			Iterator<String> keys = this.headers.keySet().iterator();
			while(keys.hasNext()) {
				String key = keys.next();
				template.header(key, this.headers.get(key));
			}
		}
	}
	
	static class MarathonErrorDecoder implements ErrorDecoder {
		@Override
		public Exception decode(String methodKey, Response response) {
			return new MarathonException(response.status(), response.reason());
		}
	}
	
	public static Marathon getInstance(String endpoint) {
		GsonDecoder decoder = new GsonDecoder(ModelUtils.GSON);
		GsonEncoder encoder = new GsonEncoder(ModelUtils.GSON);
		return Feign.builder().encoder(encoder).decoder(decoder)
				.errorDecoder(new MarathonErrorDecoder())
				.requestInterceptor(new MarathonHeadersInterceptor())
				.target(Marathon.class, endpoint);
	}
	
	public static Marathon getInstance(String endpoint, Map<String, String> headers) {
		GsonDecoder decoder = new GsonDecoder(ModelUtils.GSON);
		GsonEncoder encoder = new GsonEncoder(ModelUtils.GSON);
		return Feign.builder().encoder(encoder).decoder(decoder)
				.errorDecoder(new MarathonErrorDecoder())
				.requestInterceptor(new MarathonHeadersInterceptor(headers))
				.target(Marathon.class, endpoint);
	}
}
