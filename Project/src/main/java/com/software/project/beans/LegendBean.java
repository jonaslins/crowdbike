package com.software.project.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

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
	
	private String legendName;

	@PostConstruct
	public void getInit() {
		this.user = loginservice.getUser();
	}

	public void deleteLegend(Legend selectedLegend) {
		try {
			legendService.deleteLegend(selectedLegend);
			addMessage("Legenda removida", "Operação realizada com sucesso", FacesMessage.SEVERITY_INFO);
		} catch (Exception e) {

		}

	}
	
	public void createLegend(){
		try {
			Legend newLegend = legendService.createLegend(legendName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void addMessage(String summary, String detail, Severity severity) {
		FacesMessage message = new FacesMessage(severity, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
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

	public String getLegendName() {
		return legendName;
	}

	public void setLegendName(String legendName) {
		this.legendName = legendName;
	}

}
