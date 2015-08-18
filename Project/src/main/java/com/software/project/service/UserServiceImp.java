package com.software.project.service;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.software.project.dao.RoleDAO;
import com.software.project.dao.UserDAO;
import com.software.project.entities.User;

@Service("UserService")
@Transactional(propagation=Propagation.REQUIRED)
public class UserServiceImp implements UserService{

	@Resource
	private UserDAO dao;
	
	@Resource
	private RoleDAO roleDAO;
	
	@Override
	public List<User> getAll() {
		return dao.all();
	}

	@Override
	public void deleteUser(User user) throws Exception {
		dao.delete(user);
		
	}

	@Override
	public void createUser(User user) throws Exception {
		User fetchUser = getUserByUsername(user.getUsername());
		if(fetchUser!=null){
			throw new IllegalArgumentException(
					"Usuário \""+user.getUsername()+"\" já existe! ");
		}
		user.setRoles(Arrays.asList(roleDAO.getByName("ROLE_USER")));
		dao.createNew(user);
		
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

}
