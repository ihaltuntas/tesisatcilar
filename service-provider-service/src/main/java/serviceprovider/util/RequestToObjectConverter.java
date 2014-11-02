package serviceprovider.util;

import service.provider.common.request.LoginUserRequestDto;
import service.provider.common.request.SaveUserRequestDto;
import serviceprovider.model.User;

public class RequestToObjectConverter {

	public static User convertUser(SaveUserRequestDto saveUserRequest) {
		User user = new User();
		user.setEmail(saveUserRequest.getEmail());
		user.setLastname(saveUserRequest.getLastname());
		user.setPassword(saveUserRequest.getPassword());
		user.setUsername(saveUserRequest.getUsername());
		user.setFirstname(saveUserRequest.getFirstname());
		return user;
	}

	public static User convertUser(LoginUserRequestDto loginUserRequest) {
		User user = new User();
		user.setEmail(loginUserRequest.getEmail());
		user.setPassword(loginUserRequest.getPassword());
		return user;
	}

}
