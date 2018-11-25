package com.spring.serviceTest;



import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.spring.entity.Kitap;
import com.spring.repo.KitapRepository;
import com.spring.service.KitapService;
import com.spring.service.KitapServiceClass;

@RunWith(JUnit4.class)
public class KitapServiceClassTest  {
	@Mock
	private KitapRepository kitapRepo;
	
	private KitapService kitapService;
	
	@Before 
	public void init() {
		MockitoAnnotations.initMocks(this);
		kitapService=new KitapServiceClass(kitapRepo);
	}

	@Test
	public void ismeGoreSorguTest() {
		final List<Kitap> moccKitap= new ArrayList<Kitap>();
		Kitap mocKitap= new Kitap();
		mocKitap.setId("123456");
		mocKitap.setKitapAdi("denme");
		mocKitap.setSayfaSayisi(23);
		mocKitap.setYayinEvi("yayinEvi");
		moccKitap.add(mocKitap);
		Mockito.when(kitapRepo.findBykitapAdi(mocKitap.getKitapAdi())).thenReturn(moccKitap);
		final List<Kitap> kitap=kitapService.ismeGoreSorgulama(mocKitap.getKitapAdi());
		Assert.assertNotNull(kitap);
	}
	@Test
	public void listeTest() {
		final Kitap mocKitap=new Kitap();
		mocKitap.setId("321asdfa");
		mocKitap.setKitapAdi("deneme");
		mocKitap.setYayinEvi("yayinevi");
		mocKitap.setSayfaSayisi(212);
		List<Kitap> liste= new ArrayList<Kitap>();
		liste.add(mocKitap);
		Mockito.when(kitapRepo.findAll()).thenReturn(liste);
		final List<Kitap> list=kitapService.KitapListe();
		System.out.println(list.size());
		Assert.assertNotNull(list);
		
	}

}
