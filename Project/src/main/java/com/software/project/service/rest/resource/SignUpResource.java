package com.software.project.service.rest.resource;

import org.json.JSONException;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import com.google.gson.Gson;
import com.software.project.entities.User;
import com.software.project.service.UserService;
import com.software.project.util.ApplicationContextProvider;

public class SignUpResource extends ServerResource {

	private UserService userService;
	
	public SignUpResource() {
		userService = (UserService) ApplicationContextProvider.getBean("UserService");
	}

	@Post
	public synchronized Representation createEntity(final String representation) throws Exception {
		Gson gson = new Gson();
		String responseStr = null;

		// Getting URL request parameters keys
		String username = getQuery().getValues("username");
		String password = getQuery().getValues("pass");
		String email = getQuery().getValues("email");
		// BikePosition msg = gson.fromJson(representation, BikePosition.class);

		User user = userService.getUserByUsername(username);
		
		if (user != null) {
			responseStr = gson.toJson(new SignUpResponse(Status.USERNAME_EXISTS));
			return new JsonRepresentation(responseStr);
		}else{
			User newUser = new User(username, password, email);
			userService.createUser(newUser);
			
			responseStr = gson.toJson(new SignUpResponse(Status.USER_SUCCESSFUL_REGISTERED));
			return new JsonRepresentation(responseStr);
		}

	}

	class SignUpResponse {

		int status;

		public SignUpResponse(Status status) {
			this.status = status.getValue();
		}
		
	}

	public enum Status {
		USER_SUCCESSFUL_REGISTERED(1), USERNAME_EXISTS(2), TOKEN_NOT_VALID(3);

		private int value;

		private Status(int v) {
			this.value = v;

		}

		public int getValue() {
			return this.value;
		}

	}

}