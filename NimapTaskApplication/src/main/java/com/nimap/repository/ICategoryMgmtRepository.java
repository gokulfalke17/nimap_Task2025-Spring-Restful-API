package com.nimap.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.nimap.entity.Category;

public interface ICategoryMgmtRepository extends JpaRepository<Category, Integer> {
	Page<Category> findAll(Pageable pageable);
	

}
