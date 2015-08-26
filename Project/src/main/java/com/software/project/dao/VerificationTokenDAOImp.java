package com.software.project.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.software.project.entities.Role;
import com.software.project.entities.VerificationToken;
@Repository("VerificationTokenDAO")
public class VerificationTokenDAOImp extends GenericDAOImp<VerificationToken, Long> implements VerificationTokenDAO, Serializable {

	@Override
	public VerificationToken getByToken(String token) {
		// TODO Auto-generated method stub
		String query = "FROM VerificationToken r where r.token = :token";
		Query q = getEntityManager().createQuery(query);
		q.setParameter("token", token);
		
		List l = q.getResultList();
		if (l == null || l.isEmpty() || l.size() > 1) {
			return null;
		}
		return (VerificationToken) l.get(0);
	}
	
	
}
