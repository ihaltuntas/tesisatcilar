package service.provider.common.request;

public class RequestDtoFactory {

	public static SaveCategoryRequestDto createSaveCategoryRequestDto() {
		SaveCategoryRequestDto request = new SaveCategoryRequestDto(RequestDtoConstants.SAVE_CATEGORY_URI);
		return request;
	}

	public static SaveUserRequestDto createSaveUserRequestDto() {
		SaveUserRequestDto request = new SaveUserRequestDto(RequestDtoConstants.SAVE_USER_URI);
		return request;
	}

	public static LoginUserRequestDto createLoginUserRequestDto() {
		LoginUserRequestDto request = new LoginUserRequestDto(RequestDtoConstants.LOGIN_USER_URI);
		return request;
	}

	public static GetAllProvidersRequestDto createGetAllProvidersRequestDto() {
		GetAllProvidersRequestDto request = new GetAllProvidersRequestDto(RequestDtoConstants.GET_ALL_PROVIDERS_URI);
		return request;
	}

	public static SaveProviderRequestDto createSaveProviderRequestDto() {
		SaveProviderRequestDto request = new SaveProviderRequestDto(RequestDtoConstants.SAVE_PROVIDER_REQUEST_URI);
		return request;
	}

	public static GetCategoryRequestDto createGetCategoryReqeustDto() {
		GetCategoryRequestDto request = new GetCategoryRequestDto(RequestDtoConstants.GET_CATEGORY_REQUEST_URI);
		request.setWithoutProviders(true);
		return request;
	}

	public static GetAllCategoryIdsRequestDto createGetAllCategoryIdsRequestDto() {
		GetAllCategoryIdsRequestDto request = new GetAllCategoryIdsRequestDto(RequestDtoConstants.GET_ALL_CATEGORY_IDS_REQUESTS_URI);
		return request;
	}

	public static SaveRemembererRequestDto createSaveRemembererRequestDto() {
		SaveRemembererRequestDto request = new SaveRemembererRequestDto(RequestDtoConstants.SAVE_REMEMBERER_URI);
		return request;
	}

	public static GetAllRememberersRequestDto createGetAllRemembererRequestDto() {
		GetAllRememberersRequestDto request = new GetAllRememberersRequestDto(RequestDtoConstants.GET_ALL_REMEMBERER_LIST_URI);
		return request;
	}

	public static DeleteRemembererRequestDto createDeleteRemembererRequestDto() {
		DeleteRemembererRequestDto request = new DeleteRemembererRequestDto(RequestDtoConstants.DELETE_REMEMBERER_URI);
		return request;
	}

}
