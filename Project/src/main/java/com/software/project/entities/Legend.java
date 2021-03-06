package com.software.project.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="legends")
public class Legend{

	@Id
	@GeneratedValue
	@Column(name="legend_id")
	private Long id;
	
	@Size(min=1)
	@Column(name="legend_name", unique=true, nullable=false)
	private String name;
	
	public Legend() {
	}
	
	public Legend(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
