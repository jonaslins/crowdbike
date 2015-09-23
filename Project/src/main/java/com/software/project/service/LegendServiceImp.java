package com.software.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.software.project.dao.LegendDAO;
import com.software.project.entities.Legend;

@Service("LegendService")
@Transactional(propagation=Propagation.REQUIRED)
public class LegendServiceImp implements LegendService{
	
	@Autowired
	private LegendDAO legendDAO;
	
	public Legend getLegendByCode(String code){
		Legend legend = legendDAO.getByCode(code);		
		return legend;
	}
	
	public List<Legend> getAllLegends(){
		return legendDAO.all();
	}
}
