package com.software.project.beans;

import java.util.Calendar;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.software.project.entities.User;
import com.software.project.entities.VerificationToken;
import com.software.project.service.UserService;

@Controller("confirmAccountBean")
@Scope("request")
public class ConfirmAccountBean {
	
	@Resource
	private UserService userService;
	
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
}
