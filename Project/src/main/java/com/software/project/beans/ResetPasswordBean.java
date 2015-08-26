package com.software.project.beans;

import java.util.Calendar;
import java.util.Locale;

import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.software.project.entities.PasswordResetToken;
import com.software.project.entities.User;
import com.software.project.service.UserService;
import com.software.project.util.mail.OnPasswordResetEmailSent;
import com.software.project.util.mail.OnRegistrationCompleteEvent;

@Controller("resetPasswordBean")
@Scope("request")
public class ResetPasswordBean {

	@Resource
	private UserService userService;
	private String userEmail;
	private String newPassword;
	private String newPasswordConfirmation;
	
	private String token;
	
	@Autowired
	ApplicationEventPublisher eventPublisher;

	public void requestPasswordResetToken(){
		// TODO INSERT USER EMAIL ATTRIBUTE
		User user = userService.getUserByEmail(userEmail);
		if (user != null) {
			
			try {
				String appUrl = "http://localhost:8080";
				eventPublisher.publishEvent(
						new OnPasswordResetEmailSent(user, Locale.forLanguageTag("pt_BR"), appUrl));
				
				addMessage(null, "Check your email inbox", FacesMessage.SEVERITY_INFO);
				reset();
			} catch (Exception me) {
				//TODO send email error
			}
			
		} else {
			addMessage(null, "User e-mail not found", FacesMessage.SEVERITY_ERROR);
		}
	}

	public void addMessage(String summary, String detail, Severity severity) {
		FacesMessage message = new FacesMessage(severity, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	public void reset() {
        RequestContext.getCurrentInstance().reset("form:signUpGrid");
    }

	public void updatePassword(String token) throws Exception {
		// HttpServletRequest request = (HttpServletRequest)
		// FacesContext.getCurrentInstance().getExternalContext().getRequest();
		PasswordResetToken passwordReset = userService.getPasswordResetToken(this.token);
		if (passwordReset == null) {
			addMessage(null, "Password recover request may have expired. Try another request", FacesMessage.SEVERITY_ERROR);
			return;
		}
		
		Calendar cal = Calendar.getInstance();
		if ((passwordReset.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0) {
			addMessage(null, "Password recover request have expired. Try another request", FacesMessage.SEVERITY_ERROR);
			return;
		}		
		
		if(newPassword.equals(newPasswordConfirmation)){
			User user = passwordReset.getUser();
			user.setPassword(newPassword);
			userService.updateUser(user);
			addMessage(null, "Passwords changed successfully!", FacesMessage.SEVERITY_INFO);
		}else{
			addMessage(null, "Passwords don't match", FacesMessage.SEVERITY_ERROR);

		}
		

	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getNewPasswordConfirmation() {
		return newPasswordConfirmation;
	}

	public void setNewPasswordConfirmation(String newPasswordConfirmation) {
		this.newPasswordConfirmation = newPasswordConfirmation;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
