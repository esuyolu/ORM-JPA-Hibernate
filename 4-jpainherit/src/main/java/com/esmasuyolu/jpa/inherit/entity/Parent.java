package com.esmasuyolu.jpa.inherit.entity;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "SIBLING_TYPE")
public abstract class Parent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long entityId;
	private String entityName;
	private double entityValue;
	
	public Parent() {}
	
	public Parent(long entityId, String entityName, double entityValue) {
		this.entityId = entityId;
		this.entityName = entityName;
		this.entityValue = entityValue;
	}
	
	public long getEntityId() {
		return entityId;
	}
	public void setEntityId(long entityId) {
		this.entityId = entityId;
	}
	public String getEntityName() {
		return entityName;
	}
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
	public double getEntityValue() {
		return entityValue;
	}
	public void setEntityValue(double entityValue) {
		this.entityValue = entityValue;
	}
}
