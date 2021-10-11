package com.fullstackproject.domain;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Investment implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long code;
	private String assetCode;
	private Double coteValue;
	private Integer coteQuatity;
	private Instant dateBuy;
	
	@ManyToOne
	@JoinColumn(name = "fk_code_category")
	private Category category;
	
	public Investment() {
		
	}
	
	public Investment(Long code, String assetCode, Double coteValue, Integer coteQuatity, Instant dateBuy, Category category) {
		
		this.code = code;
		this.assetCode = assetCode;
		this.coteValue = coteValue;
		this.coteQuatity = coteQuatity;
		this.dateBuy = dateBuy;
		this.category = category;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getAssetCode() {
		return assetCode;
	}

	public void setAssetCode(String assetCode) {
		this.assetCode = assetCode;
	}

	public Double getCoteValue() {
		return coteValue;
	}

	public void setCoteValue(Double coteValue) {
		this.coteValue = coteValue;
	}

	public Integer getCoteQuatity() {
		return coteQuatity;
	}

	public void setCoteQuatity(Integer coteQuatity) {
		this.coteQuatity = coteQuatity;
	}

	public Instant getDateBuy() {
		return dateBuy;
	}

	public void setDateBuy(Instant dateBuy) {
		this.dateBuy = dateBuy;
	}
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(code);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Investment other = (Investment) obj;
		return Objects.equals(code, other.code);
	}


	
	
	
	

}
