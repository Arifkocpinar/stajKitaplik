package com.spring.service;

import java.util.List;

import com.spring.entity.Kitap;

public interface KitapService {
	List<Kitap> KitapListe();
	void KitapSil(Kitap kitap);
	List<Kitap> ismeGoreSorgulama(String kitapAdi);
	Kitap ismeGoreSorgu(String kitapAdi);
	void KitapGuncelle(Kitap kitap);
	boolean KitapEkle(Kitap kitap);
}
