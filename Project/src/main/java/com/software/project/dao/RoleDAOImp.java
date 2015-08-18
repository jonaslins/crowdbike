package com.software.project.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.software.project.entities.Role;
@Repository("RoleDAO")
public class RoleDAOImp extends GenericDAOImp<Role, Long> implements RoleDAO, Serializable {
	
	public Role getByName(String description){
		String query = "FROM Role r where r.description = :description";
		Query q = getEntityManager().createQuery(query);
		q.setParameter("description", description);
		
		List l = q.getResultList();
		if (l == null || l.isEmpty() || l.size() > 1) {
			return null;
		}
		return (Role) l.get(0);
	}
	
	
}
