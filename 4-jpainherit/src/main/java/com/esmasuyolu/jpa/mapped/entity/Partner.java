package com.esmasuyolu.jpa.mapped.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Partner {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long partnerId;
	private String partnerName;
	
	public Partner() {}
	
	public Partner(long parentId, String parentName) {
		this.partnerId = parentId;
		this.partnerName = parentName;
	}
	
	public long getParentId() {
		return partnerId;
	}
	public void setParentId(long parentId) {
		this.partnerId = parentId;
	}
	public String getParentName() {
		return partnerName;
	}
	public void setParentName(String parentName) {
		this.partnerName = parentName;
	}
	
}
