package com.spring.entity;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Document(collection="kitapUygulama")
public class Kitap {
	private String kitapAdi;
	
	private List<Yazar> yazarAdi= new ArrayList<Yazar>();
	
	@Id
	private String id;
	private String yayinEvi;
	private int sayfaSayisi;
	private Date basimTarihi;

	public String getKitapAdi() {
		return kitapAdi;
	}
	public void setKitapAdi(String kitapAdi) {
		this.kitapAdi = kitapAdi;
	}
	public List<Yazar> getYazarAdi() {
		return yazarAdi;
	}
	public void setYazarAdi(List<Yazar> yazarAdi) {
		this.yazarAdi = yazarAdi;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getYayinEvi() {
		return yayinEvi;
	}
	public void setYayinEvi(String yayinEvi) {
		this.yayinEvi = yayinEvi;
	}
	public int getSayfaSayisi() {
		return sayfaSayisi;
	}
	public void setSayfaSayisi(int sayfaSayisi) {
		this.sayfaSayisi = sayfaSayisi;
	}
	public Date getBasimTarihi() {
		return basimTarihi;
	}
	public void setBasimTarihi(Date basimTarihi) {
		this.basimTarihi = basimTarihi;
	}

}
