package com.software.project.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.software.project.entities.Legend;
import com.software.project.entities.User;
import com.software.project.service.LegendService;
import com.software.project.service.LoginService;
import com.software.project.service.UserService;

@Controller("legendBean")
@Scope("view")
public class LegendBean {

	private User user;
	
	@Resource
	private LoginService loginservice;
	
	@Resource
	private UserService userService;
	
	@Resource
	private LegendService legendService;
	
	private List<Legend> legendList;
	
	private Legend selectedLegend;
	
	
	@PostConstruct
	public void getInit(){
		this.user = loginservice.getUser();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Legend> getLegendList() {
		return legendService.getAllLegends();
	}

	public void setLegendList(List<Legend> legendList) {
		this.legendList = legendList;
	}

	public Legend getSelectedLegend() {
		return selectedLegend;
	}

	public void setSelectedLegend(Legend selectedLegend) {
		this.selectedLegend = selectedLegend;
	}

}
