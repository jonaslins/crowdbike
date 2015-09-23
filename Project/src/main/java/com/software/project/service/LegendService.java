package com.software.project.service;

import java.util.List;

import com.software.project.entities.Legend;

public interface LegendService {
	public Legend getLegendByCode(String code);
	public List<Legend> getAllLegends();
}
