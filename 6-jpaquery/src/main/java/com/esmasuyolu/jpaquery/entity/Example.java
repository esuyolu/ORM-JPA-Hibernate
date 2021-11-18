package com.esmasuyolu.jpaquery.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name = "Example.findAll", 
			query = "select e from Example as e"),
	@NamedQuery(name = "Example.findAllMin", 
	query = "select example from Example as example where example.exampleValue > :exampleValue")
})
public class Example {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long exampleId;
	private String exampleName;
	private double exampleValue;
	
	public Example() {}
	
	public Example(long exampleId, String exampleName, double exampleValue) {
		this.exampleId = exampleId;
		this.exampleName = exampleName;
		this.exampleValue = exampleValue;
	}
	
	public long getExampleId() {
		return exampleId;
	}
	public void setExampleId(long exampleId) {
		this.exampleId = exampleId;
	}
	public String getExampleName() {
		return exampleName;
	}
	public void setExampleName(String exampleName) {
		this.exampleName = exampleName;
	}
	public double getExampleValue() {
		return exampleValue;
	}
	public void setExampleValue(double exampleValue) {
		this.exampleValue = exampleValue;
	}
	
	
}
