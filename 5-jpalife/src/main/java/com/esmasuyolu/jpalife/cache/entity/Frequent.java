package com.esmasuyolu.jpalife.cache.entity;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Cacheable
public class Frequent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long frequentId;
	private String frequentName;
	
	public Frequent() {}
	
	public Frequent(long frequentId, String frequentName) {
		this.frequentId = frequentId;
		this.frequentName = frequentName;
	}
	
	public long getFrequentId() {
		return frequentId;
	}
	public void setFrequentId(long frequentId) {
		this.frequentId = frequentId;
	}
	public String getFrequentName() {
		return frequentName;
	}
	public void setFrequentName(String frequentName) {
		this.frequentName = frequentName;
	}
	
}
