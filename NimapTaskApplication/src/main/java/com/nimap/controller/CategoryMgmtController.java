package com.nimap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
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
import com.nimap.service.CategoryMgmtService;

@RestController
@RequestMapping("/api/categories")
public class CategoryMgmtController {

	@Autowired
	private CategoryMgmtService categoryService;

	// get all categories with pagination
	@GetMapping
	public ResponseEntity<Page<Category>> getAllCategories(Pageable pageable) {

		Page<Category> categories = categoryService.getAllCategories(pageable);
		return ResponseEntity.ok(categories);
	}

	// get category by id wise
	@GetMapping("/{category_id}")
	public ResponseEntity<Category> getCategoryByIdWise(@PathVariable("category_id") Integer categoryId) {
		Category category = categoryService.findCategoryByIdWise(categoryId);
		return ResponseEntity.ok(category);
	}

	// get category by id wise
	/*@GetMapping(value="/home/{id}")
	public String hh(@PathVariable("id") Integer id) {
	    System.out.println("id: " + id);
	    return "working...";
	}
	*/

	// create new category
	@PostMapping
	public ResponseEntity<Category> createNewCategory(@RequestBody Category category) {

		Category addCategory = categoryService.createCatogory(category);
		return ResponseEntity.ok(addCategory);
	}

	// for update category by id wise
	/*@PutMapping("/{category_id}")
	public ResponseEntity<Category> updateCategoryByIdWise(@PathVariable Integer category_id) {
		return new ResponseEntity<Category>(HttpStatus.OK);
	}*/
	
	@PutMapping("/{category_id}")
	public ResponseEntity<Category> updateCategoryByIdWise(@PathVariable("category_id") Integer category_id, @RequestBody Category newCategoryDetails) {
		Category updatedCategory = categoryService.updateCategoryByIdWise(category_id, newCategoryDetails);
		return ResponseEntity.ok(updatedCategory);
		
	}

	// for delete category by id wise
	@DeleteMapping("{category_id}")
	public ResponseEntity<Void> deleteCategoryByIdWise(@PathVariable("category_id") Integer Category_id) {

		categoryService.deleteCategeryByIdWise(Category_id);
		return ResponseEntity.noContent().build();
	}

}

