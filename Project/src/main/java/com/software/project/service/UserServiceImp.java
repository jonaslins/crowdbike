package com.software.project.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.software.project.dao.UserDAO;
import com.software.project.entities.User;

@Service("UserService")
@Transactional(propagation=Propagation.REQUIRED)
public class UserServiceImp implements UserService{

	@Resource
	private UserDAO dao;
	
	@Override
	public List<User> getAll() {
		return dao.all();
	}

	@Override
	public void deleteUser(User user) throws Exception {
		dao.delete(user);
		
	}

}
