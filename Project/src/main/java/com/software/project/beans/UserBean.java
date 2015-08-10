package com.software.project.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
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
	
	@Resource
	private LoginService loginservice;
	
	@Resource
	private UserService userService;
	
	@PostConstruct
	public void getInit(){
		this.user = loginservice.getUser();
	}
	
	public void deleteUser(User user) throws Exception{
		userService.deleteUser(user);
		addMessage("Usuário deletado", "Operação realizada com sucesso");
	}
	
	public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
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
	
}
