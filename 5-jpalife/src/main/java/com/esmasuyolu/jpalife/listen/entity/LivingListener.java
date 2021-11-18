package com.esmasuyolu.jpalife.listen.entity;

import javax.persistence.PostPersist;

public class LivingListener {

	@PostPersist
	public void onPostPersist(Living living) {
		System.out.println("varlık çağrılıyor..." + living.getLivingId());
	}
}
