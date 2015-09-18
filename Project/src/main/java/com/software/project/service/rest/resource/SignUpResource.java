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
import com.software.project.service.rest.resource.LoginResource.Status;
import com.software.project.util.ApplicationContextProvider;

public class SignUpResource extends ServerResource {

	private UserService userService;
	
	public SignUpResource() {
		userService = (UserService) ApplicationContextProvider.getBean("UserService");
	}

	@Post
	public synchronized Representation createEntity(final String representation) throws Exception {
		Gson gson = new Gson();
		Status status = null;

		// Getting URL request parameters keys
		String username = getQuery().getValues("username");
		String password = getQuery().getValues("pass");
		String email = getQuery().getValues("email");
		// BikePosition msg = gson.fromJson(representation, BikePosition.class);

		User user = userService.getUserByUsername(username);
		User userEmail = userService.getUserByEmail(email);
		
		if (user != null) {
			status = Status.USERNAME_EXISTS;
		}else if(userEmail!=null){
			status = Status.USER_EMAIL_EXISTS;
		}else{		
			User newUser = new User(username, password, email);
			userService.createUser(newUser);
			
			status = Status.USER_SUCCESSFUL_REGISTERED;			
		}
		
		String responseStr = gson.toJson(new SignUpResponse(status));
		return new JsonRepresentation(responseStr);

	}

	class SignUpResponse {

		int status;

		public SignUpResponse(Status status) {
			this.status = status.getValue();
		}
		
	}

	public enum Status {
		USER_SUCCESSFUL_REGISTERED(1), USERNAME_EXISTS(2), USER_EMAIL_EXISTS(3), TOKEN_NOT_VALID(4);

		private int value;

		private Status(int v) {
			this.value = v;

		}

		public int getValue() {
			return this.value;
		}

	}

}