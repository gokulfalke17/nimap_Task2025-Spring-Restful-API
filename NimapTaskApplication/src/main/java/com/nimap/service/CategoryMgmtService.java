package com.nimap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nimap.entity.Category;
import com.nimap.repository.ICategoryMgmtRepository;

@Service
public class CategoryMgmtService {

	@Autowired
	private ICategoryMgmtRepository categoryRepo;

	// get all categories available in db table using pageable
	public Page<Category> getAllCategories(Pageable pageable) {
		return categoryRepo.findAll(pageable);
	}

	// find category by its id wise
	public Category findCategoryByIdWise(Integer category_id) {
//		System.out.println("id is "+category_id);

		return categoryRepo.findById(category_id).orElseThrow(() -> new RuntimeException("Category Not Found..."));
	}

	// for add the category
	public Category createCatogory(Category category) {

		return categoryRepo.save(category);
	}

	// for update category by id wise
	public Category updateCategoryByIdWise(Integer category_id, Category newCategoryDetails) {
		Category category = findCategoryByIdWise(category_id);
		category.setCategory_name(newCategoryDetails.getCategory_name());
		return categoryRepo.save(category);
	}    

	// for delete categery by id wise
	public void deleteCategeryByIdWise(Integer categery_id) {

		categoryRepo.deleteById(categery_id);
	}

}


