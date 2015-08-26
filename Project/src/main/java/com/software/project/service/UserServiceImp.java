package com.software.project.service;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.software.project.dao.PasswordResetTokenDAO;
import com.software.project.dao.RoleDAO;
import com.software.project.dao.UserDAO;
import com.software.project.dao.VerificationTokenDAO;
import com.software.project.entities.PasswordResetToken;
import com.software.project.entities.Role;
import com.software.project.entities.User;
import com.software.project.entities.VerificationToken;

@Service("UserService")
@Transactional(propagation=Propagation.REQUIRED)
public class UserServiceImp implements UserService{

	@Resource
	private UserDAO dao;
	
	@Resource
	private RoleDAO roleDAO;
	
	@Resource
	private VerificationTokenDAO verificationTokenDAO;
	
	@Resource
	private PasswordResetTokenDAO passwordResetTokenDAO;
	
	@Override
	public List<User> getAll() {
		return dao.all();
	}

	@Override
	public void deleteUser(User user) throws Exception {
		dao.delete(user);
		
	}

	@Override
	public User createUser(User user) throws Exception {
		return dao.createNew(user);
		
	}
	
	@Override
	public User saveEnabledUser(User user) throws Exception {
		user.setEnabled(true);
		Role role = roleDAO.getByName("ROLE_USER");
		user.setRoles(Arrays.asList(role));
		return dao.update(user);
	}
	@Override
	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return dao.getByUsername(username);
	}

	@Override
	public User updateUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return dao.update(user);
	}
	
	@Override
	public VerificationToken getVerificationToken(final String token) {
		return verificationTokenDAO.getByToken(token);
	}

	@Override
	public VerificationToken createVerificationToken(User user, String token) throws Exception {
		VerificationToken verificationToken = new VerificationToken(token, user);
		return verificationTokenDAO.createNew(verificationToken);
		
	}

	@Override
	public PasswordResetToken getPasswordResetToken(String token) throws Exception {
		// TODO Auto-generated method stub
		return passwordResetTokenDAO.getByToken(token);
	}

	@Override
	public PasswordResetToken createPasswordResetToken(User user, String token) throws Exception {
		PasswordResetToken  passwordResetToken = new PasswordResetToken(token, user);
		return passwordResetTokenDAO.createNew(passwordResetToken);
	}

	@Override
	public User getUserByEmail(String userEmail) {
		// TODO Auto-generated method stub
		return dao.getByEmail(userEmail);
	}

}
