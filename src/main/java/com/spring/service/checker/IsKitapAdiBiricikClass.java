package com.spring.service.checker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.Kitap;
import com.spring.repo.KitapRepository;
@Service("IsKitapBiricikClass")
public class IsKitapAdiBiricikClass {
	
	@Autowired
	KitapRepository kitapRepo;
public boolean isBiricik(Kitap kitap) {
	if(null != kitapRepo.findByykitapAdi(kitap.getKitapAdi())) {
		return true;
	}else
		return false;
	
}
}
