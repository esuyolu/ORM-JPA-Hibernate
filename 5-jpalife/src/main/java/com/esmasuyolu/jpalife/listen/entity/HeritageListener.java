package com.esmasuyolu.jpalife.listen.entity;

import javax.persistence.PostPersist;

public class HeritageListener {

	@PostPersist
	public void onPostPersist(Mother mother) {
		System.out.println("Mother Çağrılıyor....");
	}
}
