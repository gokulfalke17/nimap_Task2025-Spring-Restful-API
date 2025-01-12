package com.nimap.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer category_id;
	
	private String category_name;

//	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	private Set<Product> products;

//	 @OneToMany(mappedBy = "category", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	 private Set<Product> products;

	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	//@JsonIgnoreProperties("category")
	private List<Product> products = new ArrayList<>();
}
