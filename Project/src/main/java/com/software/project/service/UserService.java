package com.software.project.service;

import java.util.List;

import com.software.project.entities.User;
import com.software.project.entities.VerificationToken;

public interface UserService {

	public List<User> getAll();

	public void deleteUser(User user) throws Exception;

	public User createUser(User user) throws Exception;

	public User getUserByUsername(String username);

	public User updateUser(User user) throws Exception;

	public VerificationToken getVerificationToken(String verificationToken);

	public VerificationToken createVerificationToken(User user, String token) throws Exception;

	public User saveEnabledUser(User user) throws Exception;

}
