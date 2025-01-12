package com.nimap.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.nimap.entity.Product;

public interface IProductMgmtRepository extends JpaRepository<Product, Integer> {
	
	public Page<Product> findAll(Pageable pageable);
}
