package com.software.project.service.rest.resource;

import org.json.JSONException;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

import com.google.gson.Gson;
import com.software.project.entities.User;
import com.software.project.service.LoginService;
import com.software.project.service.UserService;
import com.software.project.util.ApplicationContextProvider;

public class LoginResource extends ServerResource {

	private UserService userService;
	
	private LoginService loginService;
	
	public LoginResource() {
		userService = (UserService) ApplicationContextProvider.getBean("UserService");
		loginService = (LoginService) ApplicationContextProvider.getBean("LoginService");
	}

	@Get
	public synchronized Representation createEntity(final String representation) {
		Gson gson = new Gson();
		String responseStr = null;

		// Getting URL request parameters keys
		String username = getQuery().getValues("username");
		String password = getQuery().getValues("pass");
		
		Status status = Status.LOGIN_SUCCESSFUL;
		
		try{
			
			User user = loginService.login(username, password);
			
		}catch(IllegalArgumentException e){			
			
			status = Status.INVALID_USERNAME_OR_PASSWORD;
			
		}
		
		
		responseStr = gson.toJson(new LoginResponse(status));
		return new JsonRepresentation(responseStr);

	}

	class LoginResponse {

		int status;

		public LoginResponse(Status status) {
			this.status = status.getValue();
		}
		
	}

	public enum Status {
		LOGIN_SUCCESSFUL(1), INVALID_USERNAME_OR_PASSWORD(2);

		private int value;

		private Status(int v) {
			this.value = v;

		}

		public int getValue() {
			return this.value;
		}

	}

}