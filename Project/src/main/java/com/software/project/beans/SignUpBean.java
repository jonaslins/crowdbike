package com.software.project.beans;

import java.util.Calendar;
import java.util.Locale;

import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.software.project.entities.User;
import com.software.project.entities.VerificationToken;
import com.software.project.service.UserService;
import com.software.project.util.mail.OnRegistrationCompleteEvent;

@Controller("signUpBean")
@Scope("request")
public class SignUpBean {
	private String username;
	private String password;
	private String confirmPassword;
	
	@Autowired
	ApplicationEventPublisher eventPublisher;
	
	@Resource
	private UserService userService;
	
	public void createAccount() throws Exception{
		User user = new User(username, password);
		
		User newUser = userService.createUser(user);
		if(newUser==null){
			//TODO Send message error
		}else{
			
			try {
				String appUrl = "http://localhost:8080";
				eventPublisher.publishEvent(new OnRegistrationCompleteEvent
						(newUser, Locale.forLanguageTag("pt_BR"), appUrl));
				
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage("Welcome " + username));
				
				reset();
			} catch (Exception me) {
				//TODO send email error
			}
		}
		
	}
	
	
	public String confirmRegistration(String token) throws Exception {
//		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	    VerificationToken verificationToken = userService.getVerificationToken(token);
	    if (verificationToken == null) {
//	        TODO VERIFICATION EXPIRED
	    }
	     
	    User user = verificationToken.getUser();
	    Calendar cal = Calendar.getInstance();
	    if ((verificationToken.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0) {
//	         TODO VERIFICATION EXPIRED
	    } 

	    userService.saveEnabledUser(user); 
	    return "homePage"; 
	}
	
	public void reset() {
        RequestContext.getCurrentInstance().reset("form:signUpGrid");
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
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	
	
}
