package com.spring.ControllerTest;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.spring.entity.Kitap;
import com.spring.entity.Yazar;
import com.spring.service.KitapServiceClass;


public class KitapControllerTest extends kitapTest {

	@Autowired 
	private WebApplicationContext webApp;
	
	@Autowired
	private KitapServiceClass kitapService;
	
	private MockMvc mvc;
	
	@Before
	public void setup(){
		mvc=MockMvcBuilders.webAppContextSetup(webApp).build();
		}
	@Test
	public void ekleTest() throws Exception {
		final Kitap kitap= new Kitap();
		final List<Yazar> yazarListe= new ArrayList<Yazar>();
		final Yazar yazar= new Yazar();
		yazar.setYazarAdi("yazarAdi");
		yazarListe.add(yazar);
		kitap.setId("1321sdf");
		kitap.setKitapAdi("kitapASdi");
		kitap.setSayfaSayisi(1212);
		kitap.setYayinEvi("yayinevi");
		kitap.setYazarAdi(yazarListe);
		 mvc.perform(post("/kitap/ekle").contentType(MediaType.APPLICATION_JSON).content(asJsonString(kitap)));
	}
	@Test
	public void guncelleTest() throws Exception {
		final Kitap kitap= new Kitap();
		final List<Yazar> yazarListe= new ArrayList<Yazar>();
		final Yazar yazar= new Yazar();
		yazar.setYazarAdi("GuncelYazar");
		yazarListe.add(yazar);
		kitap.setId("1321sdf");
		kitap.setKitapAdi("kitapASdi");
		kitap.setSayfaSayisi(1212);
		kitap.setYayinEvi("yayinevi");
		kitap.setYazarAdi(yazarListe);
		mvc.perform(put("/kitap/guncelle").contentType(MediaType.APPLICATION_JSON).content(asJsonString(kitap)));
	}

	
	public static String asJsonString(final Object obj) {
	    try {
	        return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
}
