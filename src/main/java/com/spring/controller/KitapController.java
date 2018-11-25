package com.spring.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;


import com.spring.entity.Kitap;

import com.spring.service.KitapServiceClass;

@RestController
@RequestMapping("/kitap")
public class KitapController {

	@Autowired
	private KitapServiceClass servis;

	
	@CrossOrigin
	@RequestMapping(value = "/ekle", method = RequestMethod.POST)
	public ResponseEntity<String> create(@RequestBody Kitap kitap) {
		Kitap k=kitap;
		if(servis.KitapEkle(k)==true) {
			return new ResponseEntity<String>("Ekleme Başarılı",HttpStatus.OK);
		}else
			return new ResponseEntity<String>("Aynı isimde kitap mevcut",HttpStatus.BAD_REQUEST);
		
		
	}

	@CrossOrigin
	@RequestMapping(value = "/kitaps", method = RequestMethod.GET)
	public List<Kitap> list() {
		System.out.println("***********************************");
		List<Kitap> kitap= new ArrayList<Kitap>();
		kitap=servis.KitapListe();
		return kitap;
	}
	@CrossOrigin
	@RequestMapping(value="/kitaps/{id}",method=RequestMethod.GET)
	public Optional<Kitap> kitapBulId(@Valid @PathVariable("id") String id) {
		System.out.println("geldi----------");
		return servis.idyeGoreSorgulama(id);
	}
	@CrossOrigin
	@RequestMapping(value = "/guncelle", method = RequestMethod.POST)
	public void update(@RequestBody Kitap kitap) {
		
		servis.KitapGuncelle(kitap);
	}
	@CrossOrigin
	@RequestMapping(value = "/sil", method = RequestMethod.DELETE)
	public void delete(@RequestBody Kitap kitap) {
		
		servis.KitapSil(kitap);
	}
	@CrossOrigin
	@RequestMapping(value="/sorgu",method=RequestMethod.POST)
	public List<Kitap> kitapİsmiSorgulama(@RequestBody Kitap kitap) {
		
		return servis.ismeGoreSorgulama(kitap.getKitapAdi());
	}
	@CrossOrigin
	@RequestMapping(value="/sorgu/{kitap}")
	public List<Kitap> kitapSorgulama(@Valid @PathVariable("kitap") String kitap) {
		
		System.out.println(kitap);
		return servis.ismeGoreSorgulama(kitap);
		
	}
}
