package com.esmasuyolu.jpalife.listen.entity;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

@Entity
@EntityListeners({LivingListener.class})
public class Living {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long livingId;
	private String firstName;
	private String lastName;
	private boolean emptyName;
	
	@PrePersist
	public void onPrePersist() {
		System.out.println("Çağrılıyor....");
		if (firstName == null || firstName.equals("") || lastName == null || lastName.equals(""))
			emptyName = true;
	}
	
	public long getLivingId() {
		return livingId;
	}
	public void setLivingId(long livingId) {
		this.livingId = livingId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public boolean isEmptyName() {
		return emptyName;
	}
	public void setEmptyName(boolean emptyName) {
		this.emptyName = emptyName;
	}
	
}
