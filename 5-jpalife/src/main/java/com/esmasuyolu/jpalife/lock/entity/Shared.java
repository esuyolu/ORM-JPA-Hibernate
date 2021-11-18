package com.esmasuyolu.jpalife.lock.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class Shared {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long sharedId;
	
	private String sharedName;
	
	@Version
	private long versionNumer;

	public long getSharedId() {
		return sharedId;
	}

	public void setSharedId(long sharedId) {
		this.sharedId = sharedId;
	}

	public String getSharedName() {
		return sharedName;
	}

	public void setSharedName(String sharedName) {
		this.sharedName = sharedName;
	}

	public long getVersionNumer() {
		return versionNumer;
	}

	public void setVersionNumer(long versionNumer) {
		this.versionNumer = versionNumer;
	}
	
}
