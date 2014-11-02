package service.provider.common.request;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import service.provider.common.dto.AbstractRequestDto;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetAllRememberersRequestDto extends AbstractRequestDto {

	GetAllRememberersRequestDto() {

	}

	GetAllRememberersRequestDto(String getAllRememberersRequestUri) {
		setRequestUri(getAllRememberersRequestUri);
	}

	public boolean isValid() {
		return true;
	}

}
