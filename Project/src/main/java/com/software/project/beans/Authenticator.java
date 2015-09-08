package com.software.project.beans;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import com.software.project.entities.User;
import com.software.project.service.LoginService;

@Controller
@Scope("request")
public class Authenticator implements AuthenticationProvider {
	@Autowired
	private LoginService service;

	@Autowired
	private UserSession session;

	private String username;
	private String password;


	public void login() {
		try {
			User user = service.login(username, password);
			if(user.isEnabled()){
//				TODO CONTA CONFIRMADA
			}else{
//				TODO CONTA NAO CONFIRMADA
			}
			loginSpringSecurity(user);
			session.setUser(user);
		    FacesContext.getCurrentInstance().getExternalContext().redirect("pages/home.jsf");
		    return;
		} catch (IllegalArgumentException ex) {
			
			String msg = getMessage("user.authentication.login.error");
			addMessage(msg, null, FacesMessage.SEVERITY_ERROR);
			
		} catch (IOException e) {
		}
	}

	private String getMessage(String messageId){		
		FacesContext context = FacesContext.getCurrentInstance();
		ResourceBundle bundle = context.getApplication().getResourceBundle(context, "message");
		return bundle.getString(messageId);
	}
	private void loginSpringSecurity(User user) {
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
				user.getUsername(), null, user.getRoles());
		token.setDetails(user);

		SecurityContextHolder.createEmptyContext();
		SecurityContextHolder.getContext().setAuthentication(token);
	}

	public String logout() {
		SecurityContextHolder.clearContext();
		session.setUser(null);
		return "index";
	}

	public void addMessage(String summary, String detail, Severity severity) {
        FacesMessage message = new FacesMessage(severity, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public Authentication authenticate(Authentication arg0)
			throws AuthenticationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
