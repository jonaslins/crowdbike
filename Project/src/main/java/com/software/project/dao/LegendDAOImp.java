package com.software.project.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.software.project.entities.Legend;
import com.software.project.entities.Role;
import com.software.project.entities.VerificationToken;
@Repository("LegendDAO")
public class LegendDAOImp extends GenericDAOImp<Legend, Long> implements LegendDAO, Serializable {


	@Override
	public Legend getByCode(String code) {
		// TODO Auto-generated method stub
		String query = "FROM Legend l where l.name = :name";
		Query q = getEntityManager().createQuery(query);
		q.setParameter("name", code);
		
		List l = q.getResultList();
		if (l == null || l.isEmpty() || l.size() > 1) {
			return null;
		}
		return (Legend) l.get(0);
	}	
	
}
