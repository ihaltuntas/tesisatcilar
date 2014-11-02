package service.provider.client.executor;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import service.provider.common.dto.AbstractRequestDto;
import service.provider.common.dto.Validatable;
import service.provider.common.request.DeleteRemembererRequestDto;
import service.provider.common.request.GetAllCategoryIdsRequestDto;
import service.provider.common.request.GetAllProvidersRequestDto;
import service.provider.common.request.GetAllRememberersRequestDto;
import service.provider.common.request.GetCategoryRequestDto;
import service.provider.common.request.LoginUserRequestDto;
import service.provider.common.request.SaveCategoryRequestDto;
import service.provider.common.request.SaveProviderRequestDto;
import service.provider.common.request.SaveRemembererRequestDto;
import service.provider.common.request.SaveUserRequestDto;
import service.provider.common.response.AbstractResponseDto;
import service.provider.common.response.DeleteRemembererResponseDto;
import service.provider.common.response.GetAllCategoryIdsResponseDto;
import service.provider.common.response.GetAllProvidersResponseDto;
import service.provider.common.response.GetAllRememberersResponseDto;
import service.provider.common.response.GetCategoryResponseDto;
import service.provider.common.response.LoginUserResponseDto;
import service.provider.common.response.SaveProviderResponseDto;
import service.provider.common.response.SaveRemembererResponseDto;
import service.provider.common.response.SaveUserResponseDto;

public class ServiceClient {

	private final static String urlRoot = "http://www.kelepirpc.com/";
	// private final static String urlRoot = "http://localhost:8080/";

	private final static ObjectMapper objectMapper = new ObjectMapper();

	public static <Req extends AbstractRequestDto> String convertToJson(Req req) {
		try {
			return objectMapper.writeValueAsString(req);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	public static DeleteRemembererResponseDto deleteRememberer(DeleteRemembererRequestDto deleteRemembererRequestDto) {
		return process(deleteRemembererRequestDto, DeleteRemembererResponseDto.class, DeleteRemembererRequestDto.class);
	}

	public static GetAllRememberersResponseDto getAllRemembererList(GetAllRememberersRequestDto getAllRemembererRequestDto) {
		return process(getAllRemembererRequestDto, GetAllRememberersResponseDto.class, GetAllRememberersRequestDto.class);
	}

	public static GetCategoryResponseDto saveCategory(SaveCategoryRequestDto saveCategoryRequest) {
		return process(saveCategoryRequest, GetCategoryResponseDto.class, SaveCategoryRequestDto.class);
	}

	public static SaveRemembererResponseDto saveRememberer(SaveRemembererRequestDto saveRememberer) {
		return process(saveRememberer, SaveRemembererResponseDto.class, SaveRemembererRequestDto.class);
	}

	public static GetAllCategoryIdsResponseDto getAllCategoryIds(GetAllCategoryIdsRequestDto getAllCategoryIds) {
		return process(getAllCategoryIds, GetAllCategoryIdsResponseDto.class, GetAllCategoryIdsRequestDto.class);
	}

	public static GetCategoryResponseDto getCategory(GetCategoryRequestDto getCategoryRequest) {
		return process(getCategoryRequest, GetCategoryResponseDto.class, GetCategoryRequestDto.class);
	}

	/**
	 * Ornek kullanim: SaveProviderRequestDto saveProviderRequest = RequestDtoFactory.createSaveProviderRequestDto(); ProviderDto providerDto = new ProviderDto(); // Zorunlu alanlar providerDto.setGsm("5426781232");
	 * providerDto.setTckn("123213"); providerDto.setTitle("Murtaza Kuruyemis"); saveProviderRequest.setProviderDto(providerDto); SaveProviderResponseDto response = ServiceClient.saveProvider(saveProviderRequest);
	 */
	public static SaveProviderResponseDto saveProvider(SaveProviderRequestDto saveProviderRequest) {
		return process(saveProviderRequest, SaveProviderResponseDto.class, SaveProviderRequestDto.class);
	}

	public static GetAllProvidersResponseDto getAllProviders(GetAllProvidersRequestDto getAllProvidersRequest) {
		return process(getAllProvidersRequest, GetAllProvidersResponseDto.class, GetAllProvidersRequestDto.class);
	}

	/**
	 * Saves given user to database.
	 * 
	 * @param saveUserRequest
	 * @return Null if called with null parameters.
	 */
	public static SaveUserResponseDto saveUser(SaveUserRequestDto saveUserRequest) {
		if (!isRequestValid(saveUserRequest)) {
			return null;
		}
		SaveUserResponseDto serviceResponse = null;
		HttpClient httpClient = new DefaultHttpClient();
		try {
			ObjectMapper mapper = new ObjectMapper();
			HttpPost request = new HttpPost(urlRoot + saveUserRequest.getRequestUri());
			String jsonConversion = mapper.writeValueAsString(saveUserRequest);
			StringEntity params = new StringEntity(jsonConversion);
			request.addHeader("content-type", "application/json");
			request.setEntity(params);
			SaveUserRequestDto parserRequest = mapper.readValue(jsonConversion, SaveUserRequestDto.class);
			HttpResponse response = httpClient.execute(request);
			HttpEntity entity = response.getEntity();
			String responseString = EntityUtils.toString(entity, "UTF-8");
			serviceResponse = mapper.readValue(responseString, SaveUserResponseDto.class);
			return serviceResponse;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			httpClient.getConnectionManager().shutdown();
		}
		return serviceResponse;
	}

	/**
	 * Authenticates user into server.
	 */
	public static LoginUserResponseDto loginUser(LoginUserRequestDto loginRequest) {
		if (!isRequestValid(loginRequest)) {
			return null;
		}
		LoginUserResponseDto serviceResponse = null;
		HttpClient httpClient = new DefaultHttpClient();
		try {
			ObjectMapper mapper = new ObjectMapper();
			HttpPost request = new HttpPost(urlRoot + loginRequest.getRequestUri());
			String jsonConversion = mapper.writeValueAsString(loginRequest);
			StringEntity params = new StringEntity(jsonConversion);
			request.addHeader("content-type", "application/json");
			request.setEntity(params);
			LoginUserRequestDto parserRequest = mapper.readValue(jsonConversion, LoginUserRequestDto.class);
			HttpResponse response = httpClient.execute(request);
			HttpEntity entity = response.getEntity();
			String responseString = EntityUtils.toString(entity, "UTF-8");
			serviceResponse = mapper.readValue(responseString, LoginUserResponseDto.class);
			return serviceResponse;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			httpClient.getConnectionManager().shutdown();
		}
		return serviceResponse;
	}

	private static boolean isRequestValid(Validatable request) {
		if (request == null) {
			return false;
		} else {
			return request.isValid();
		}
	}

	private static <R extends AbstractResponseDto, Req extends AbstractRequestDto> R process(Req req, Class<R> responseClass, Class<Req> requestClass) {
		if (!req.isValid()) {
			return null;
		}
		R serviceResponse = null;
		HttpClient httpClient = new DefaultHttpClient();
		try {
			ObjectMapper mapper = new ObjectMapper();
			HttpPost request = new HttpPost(urlRoot + req.getRequestUri());
			String jsonConversion = mapper.writeValueAsString(req);
			StringEntity params = new StringEntity(jsonConversion);
			request.addHeader("content-type", "application/json");
			request.setEntity(params);
			Req parserRequest = (Req) mapper.readValue(jsonConversion, requestClass);
			HttpResponse response = httpClient.execute(request);
			HttpEntity entity = response.getEntity();
			String responseString = EntityUtils.toString(entity, "UTF-8");
			serviceResponse = mapper.readValue(responseString, responseClass);
			return serviceResponse;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			httpClient.getConnectionManager().shutdown();
		}
		return serviceResponse;
	}

}
