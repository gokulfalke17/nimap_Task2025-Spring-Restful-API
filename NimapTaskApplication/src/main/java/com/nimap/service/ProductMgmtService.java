package com.nimap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nimap.entity.Category;
import com.nimap.entity.Product;
import com.nimap.repository.IProductMgmtRepository;

@Service
public class ProductMgmtService {

	@Autowired
	private IProductMgmtRepository productRepo;

	// get all Product avalible in db table using pageable
	public Page<Product> getAllProducts(Pageable pageable) {

		return productRepo.findAll(pageable);
	}

	// get product by id wise
	/*
	public Product getProductByIdWise(Integer product_id) {
		
		return productRepo.findById(product_id).orElseThrow(()-> new RuntimeException("Invalid Product Id, Product Not Found...")); 
	}
	*/
	
	public Product getProductByIdWise(Integer product_id) {

		Product product = productRepo.findById(product_id)
				.orElseThrow(() -> new RuntimeException("Invalid Prodcut Id, Product Not Found..."));
		
		Category category = product.getCategory();
		if(category==null) {
			throw new RuntimeException("Product does not having Valid Catgory Associated.");
		}
		
		return product;
	}
	
	//for add the product
	public Product createProduct(Product product) {
		
		if(product.getCategory()!=null) {
			product.getCategory().getProducts().add(product);
		}
		
		return productRepo.save(product);
	}
	
	// for update product by id wise
	public Product updateProduct(Integer product_id, Product newproductDetails) {
		
		Product product = getProductByIdWise(product_id);
		product.setProduct_name(newproductDetails.getProduct_name());
		product.setProduct_price(newproductDetails.getProduct_price());
		
		return productRepo.save(product);
	}
	
	//for delete product by id wise
	public void deleteProduct(Integer product_id) {
		
		productRepo.deleteById(product_id); 
	}
	
}
