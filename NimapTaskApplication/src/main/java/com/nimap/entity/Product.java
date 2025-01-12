package com.nimap.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer product_id;
	
	private String product_name;
	
	private Double product_price;
	
//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name = "category_id")
//	private Category category;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    @JsonBackReference // Breaks the circular reference
    private Category category;


}
