package com.fullstackproject.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codeCategoryLong;
	private String name;
	private String description;
	
	public Category() {
		
	}
	public Category(Long codeCategoryLong, String name, String description) {
		super();
		this.codeCategoryLong = codeCategoryLong;
		this.name = name;
		this.description = description;
	}
	public Long getCodeCategoryLong() {
		return codeCategoryLong;
	}
	public void setCodeCategoryLong(Long codeCategoryLong) {
		this.codeCategoryLong = codeCategoryLong;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	

}
