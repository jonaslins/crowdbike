package com.software.project.service;

import java.util.List;

import com.software.project.entities.User;

public interface UserService {

	public List<User> getAll();

	public void deleteUser(User user) throws Exception;

}
