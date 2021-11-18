package com.esmasuyolu.jpalife.listen.entity;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;

@MappedSuperclass
@EntityListeners({HeritageListener.class})
public class Mother {

	private String nameField;
	
	@PrePersist
	public void onPrePersist() {
		System.out.println("Çağrılıyor....");
	}

	public String getNameField() {
		return nameField;
	}

	public void setNameField(String nameField) {
		this.nameField = nameField;
	}
	
	
}
