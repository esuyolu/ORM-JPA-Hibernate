package com.esmasuyolu.jpareal;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Realistic {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long realisticId;
	@Column(length = 80, nullable = false, unique = true, updatable = true)
	private String realisticName;
	@Column(precision = 12, scale = 2)
	private double realisticValue;
	
	public Realistic() {}
	
	public Realistic(long realisticId, String realisticName, double realisticValue) {
		this.realisticId = realisticId;
		this.realisticName = realisticName;
		this.realisticValue = realisticValue;
	}
	
	public long getRealisticId() {
		return realisticId;
	}
	public void setRealisticId(long realisticId) {
		this.realisticId = realisticId;
	}
	public String getRealisticName() {
		return realisticName;
	}
	public void setRealisticName(String realisticName) {
		this.realisticName = realisticName;
	}
	public double getRealisticValue() {
		return realisticValue;
	}
	public void setRealisticValue(double realisticValue) {
		this.realisticValue = realisticValue;
	}

	@Override
	public int hashCode() {
		return Objects.hash(realisticId, realisticName, realisticValue);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Realistic other = (Realistic) obj;
		return realisticId == other.realisticId && Objects.equals(realisticName, other.realisticName)
				&& Double.doubleToLongBits(realisticValue) == Double.doubleToLongBits(other.realisticValue);
	}
	
}
