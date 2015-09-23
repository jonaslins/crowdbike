package com.software.project.dao;

import java.util.List;

import com.software.project.entities.Legend;

public interface LegendDAO extends GenericDAO<Legend, Long> {
	Legend getByCode(String code);
}
