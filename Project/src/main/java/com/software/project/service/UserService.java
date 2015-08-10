package com.software.project.service;

import java.util.List;

import com.software.project.entities.User;

public interface UserService {

	public List<User> getAll();

	public void deleteUser(User user) throws Exception;

	public void createUser(User user) throws Exception;

	public User getUserByUsername(String username);

	public User updateUser(User user) throws Exception;

}
