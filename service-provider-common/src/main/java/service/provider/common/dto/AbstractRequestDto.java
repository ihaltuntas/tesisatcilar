package service.provider.common.dto;

import java.util.Map;

public abstract class AbstractRequestDto implements Validatable {
	private String requestUri;

	private Map<String, String> metaData;

	public void setMetaData(Map<String, String> metaData) {
		this.metaData = metaData;
	}

	public String getRequestUri() {
		return requestUri;
	}

	public void setRequestUri(String requestUri) {
		this.requestUri = requestUri;
	}

	public Map<String, String> getMetaData() {
		return metaData;
	}

}
