package com.spring.entity;

import org.springframework.data.mongodb.core.mapping.Field;

public class Yazar {
	@Field("yazarAdi")
	private String yazarAdi;

	public String getYazarAdi() {
		return yazarAdi;
		
	}
	public void setYazarAdi(String yazarAdi) {
		this.yazarAdi = yazarAdi;
		
	}
}
