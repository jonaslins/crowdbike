package com.software.project.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.software.project.entities.User;
import com.software.project.service.LoginService;
import com.software.project.service.UserService;

@Controller("userbean")
@Scope("view")
public class UserBean {

	private User user;
	private String nome;
	private List<User> users;
	private User selectedUser;
	
	private String username;
	private String password;
	
	private String newPassword;
	private String currentPassword;
	private String confirmPassword;
	
	@Resource
	private LoginService loginservice;
	
	@Resource
	private UserService userService;
	
	@PostConstruct
	public void getInit(){
		this.user = loginservice.getUser();
	}
	
	public void createUser() throws Exception{
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		userService.createUser(user);
	}
	
	public void updateUser(User user) throws Exception{
		user.setUsername(username);
		user.setPassword(password);
		userService.updateUser(user);
	}
	
	public void deleteUser(User user) throws Exception{
		userService.deleteUser(user);
		addMessage("Usuário deletado", "Operação realizada com sucesso", FacesMessage.SEVERITY_INFO);
	}
	
	public void addMessage(String summary, String detail, Severity severity) {
        FacesMessage message = new FacesMessage(severity, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
	
	public void changeUserPassword() throws Exception{
		if(currentPassword.equals(user.getPassword())){
			if(newPassword.equals(confirmPassword)){
				user.setPassword(newPassword);
				userService.updateUser(user);
			}else{
				addMessage("Nova senha e confirmação de senha não conferem", "", FacesMessage.SEVERITY_ERROR);
			}
		}else{
			addMessage("Senha atual não confere", "", FacesMessage.SEVERITY_ERROR);
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getNome() {
		return user.getUsername();
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<User> getUsers() {
		return userService.getAll();
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User getSelectedUser() {
		return selectedUser;
	}

	public void setSelectedUser(User selectedUser) {
		this.selectedUser = selectedUser;
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

	public String getCurrentPassword() {
		return currentPassword;
	}

	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
}
