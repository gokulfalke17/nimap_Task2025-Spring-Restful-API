package com.nimap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nimap.entity.Category;
import com.nimap.entity.Product;
import com.nimap.service.ProductMgmtService;
import com.nt.response.ProductResponse;

@RestController
@RequestMapping("/api/products")
public class ProductMgmtController {

	@Autowired
	private ProductMgmtService productService;

	// get all products with pagenation
	@GetMapping
	public ResponseEntity<Page<Product>> getAllProducts(Pageable pageable) {

		Page<Product> products = productService.getAllProducts(pageable);
		return ResponseEntity.ok(products);
	}

	// get product by its id wise
	@GetMapping("/{product_id}")
	public ResponseEntity<ProductResponse> getProductByIdWise(@PathVariable("product_id") Integer Product_id) {
		Product product = productService.getProductByIdWise(Product_id);
		ProductResponse prodResponse = new ProductResponse();
		prodResponse.setProduct_id(product.getProduct_id());
		prodResponse.setProduct_name(product.getProduct_name());
		prodResponse.setProduct_price(product.getProduct_price());
		Category category = product.getCategory();
		if (category != null) {
			prodResponse.setCategory_id(category.getCategory_id());
			prodResponse.setCategory_name(category.getCategory_name());
		}

		return ResponseEntity.ok(prodResponse);

	}

	// create new product
	/*@PostMapping
	public ResponseEntity<Product> createProduct(@PathVariable Product product) {
		
		Product createProduct = productService.createProduct(product);
		return ResponseEntity.ok(createProduct);
	}
	*/
	

	@PostMapping
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {

		if (product.getCategory() == null || product.getCategory().getCategory_id() == null) {
			throw new RuntimeException("Product Must be have Category Id (OR) Category");
		} 

		Product createProduct = productService.createProduct(product);
		return ResponseEntity.ok(createProduct);
	}

	/*//for update product by id wise
	@PutMapping("/{product_id}")
	public ResponseEntity<Product> updateCategeryByIdWise(@PathVariable Long product_id, @RequestBody Product newProductDetails) {
		
		Product updatedProduct = productService.updateProduct(product_id, newProductDetails);
		return ResponseEntity.ok(updatedProduct);
	}*/

	@PutMapping("/{product_id}")
	public ResponseEntity<Product> updateCategeryByIdWise(@PathVariable("product_id") Integer product_id,
			@RequestBody Product newProductDetails) {
		Product updatedProduct = productService.updateProduct(product_id, newProductDetails);
		return ResponseEntity.ok(updatedProduct);
	}

	// for delete product by id wise
	@DeleteMapping("/{product_id}")
	public ResponseEntity<Void> deleteProductByIdWise(@PathVariable("product_id") Integer Product_id) {
		productService.deleteProduct(Product_id);
		return ResponseEntity.noContent().build();
	}

}
