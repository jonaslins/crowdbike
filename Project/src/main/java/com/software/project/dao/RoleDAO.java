package com.software.project.dao;

import com.software.project.entities.Role;

public interface RoleDAO extends GenericDAO<Role, Long> {
	public Role getByName(String name);
}
