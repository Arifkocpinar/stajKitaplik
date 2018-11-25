package com.spring.repo;



import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.entity.Kitap;

@Repository
public interface KitapRepository extends MongoRepository<Kitap,String > {
	List<Kitap> findAll();
	@Query("{kitapAdi: {$regex:?0}}")
	List<Kitap> findBykitapAdi(String kitapAdi);
	@Query("{kitapAdi:?0 }")
	Kitap findByykitapAdi(String kitapAdi);
}
