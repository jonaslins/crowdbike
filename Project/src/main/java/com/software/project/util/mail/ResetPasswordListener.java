package com.software.project.util.mail;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.MessageSource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.software.project.entities.User;
import com.software.project.service.UserService;

@Component
public class ResetPasswordListener implements ApplicationListener<OnPasswordResetEmailSent> {
    @Autowired
    private UserService service;
    @Autowired
    private MessageSource messages;
    @Autowired
    private JavaMailSender mailSender;
 
    @Override
    public void onApplicationEvent(OnPasswordResetEmailSent event) {
        try {
			this.resetPasswordEmail(event);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
 
    private void resetPasswordEmail(OnPasswordResetEmailSent event) throws Exception {
    	  User user = event.getUser();
          String token = UUID.randomUUID().toString();
          service.createPasswordResetToken(user, token);
           
          String recipientAddress = user.getEmail();
          String subject = "Change password request";
          String confirmationUrl = event.getAppUrl() + "/project/pages/user/resetPassword/updatePassword.jsf?token=" + token;
          String message = "";//messages.getMessage("message.regSucc", null, event.getLocale());
          SimpleMailMessage email = new SimpleMailMessage();
          email.setTo(recipientAddress);
          email.setSubject(subject);
          email.setText(message + "Hello " + user.getUsername() + "\n"
          		+ "Click on the link below to change your password:\n" + confirmationUrl);
          mailSender.send(email);
      }
    }