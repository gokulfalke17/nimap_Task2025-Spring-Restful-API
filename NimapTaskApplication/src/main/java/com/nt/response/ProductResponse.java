package com.nt.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
	
	private Integer product_id;
	private String product_name;
	private Double product_price;
	
	private Integer category_id;
	private String category_name;
}
