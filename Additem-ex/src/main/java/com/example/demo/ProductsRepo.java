package com.example.demo;


import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsRepo extends CrudRepository<Products, Long> {

	Optional<Products> findByName(String fileName);
	
	List<Products> findAll();

}