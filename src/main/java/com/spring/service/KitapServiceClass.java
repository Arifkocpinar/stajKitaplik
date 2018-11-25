package com.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.Kitap;
import com.spring.repo.KitapRepository;
import com.spring.service.checker.*;
@Service("KitapServiceClass")
public class KitapServiceClass implements KitapService {
	private final KitapRepository kitapRepo;
	@Autowired
	public KitapServiceClass(KitapRepository kitapepo) {
	this.kitapRepo=kitapepo;
	}
	@Autowired
	IsKitapAdiBiricikClass biricik;

	public boolean KitapEkle(Kitap kitap) {
		
		if(biricik.isBiricik(kitap)==false) {
		kitapRepo.insert(kitap);
		return true;
		}
		else 		
		 return false;	
		
		
	}

	public void KitapGuncelle(Kitap kitap) {
		kitapRepo.save(kitap);
		
	}

	public void KitapSil(Kitap kitap) {
		
		kitapRepo.deleteById(kitap.getId());
		
		
	}

	public List<Kitap> KitapListe() {
		List<Kitap> kitap= new ArrayList<Kitap>();
		kitap=kitapRepo.findAll();
		return kitap;

	}
	public List<Kitap> ismeGoreSorgulama(String kitapAdi) {
		return kitapRepo.findBykitapAdi(kitapAdi);
	}
	public Kitap ismeGoreSorgu(String kitapAdi) {
		return kitapRepo.findByykitapAdi(kitapAdi);
	}
	public Optional<Kitap> idyeGoreSorgulama(String id) {
		
		return kitapRepo.findById(id);
	}


}
