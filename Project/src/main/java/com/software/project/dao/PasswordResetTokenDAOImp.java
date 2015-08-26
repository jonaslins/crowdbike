package com.software.project.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.software.project.entities.PasswordResetToken;
@Repository("PasswordResetTokenDAO")
public class PasswordResetTokenDAOImp extends GenericDAOImp<PasswordResetToken, Long> implements PasswordResetTokenDAO, Serializable {

	@Override
	public PasswordResetToken getByToken(String token) {
		// TODO Auto-generated method stub
		String query = "FROM PasswordResetToken r where r.token = :token";
		Query q = getEntityManager().createQuery(query);
		q.setParameter("token", token);
		
		List l = q.getResultList();
		if (l == null || l.isEmpty() || l.size() > 1) {
			return null;
		}
		return (PasswordResetToken) l.get(0);
	}
	
	
}
