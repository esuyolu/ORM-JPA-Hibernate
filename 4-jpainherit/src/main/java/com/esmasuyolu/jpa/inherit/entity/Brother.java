package com.esmasuyolu.jpa.inherit.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("BROTHER")
public class Brother extends Parent {

	private boolean brotherCheck;
	
	public Brother() {}
	
	public Brother(long entityId, String entityName, double entityValue, boolean brotherCheck) {
		super(entityId, entityName, entityValue);
		this.brotherCheck = brotherCheck;
	}
	
	public boolean isBrotherCheck() {
		return brotherCheck;
	}
	public void setBrotherCheck(boolean brotherCheck) {
		this.brotherCheck = brotherCheck;
	}
}
