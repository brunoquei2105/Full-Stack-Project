package com.fullstackproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fullstackproject.domain.Category;
import com.fullstackproject.repository.CategoryRepository;



@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	
	public List<Category> findAll(){
		return categoryRepository.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> objectOptional = categoryRepository.findById(id);
		return objectOptional.orElseThrow();
	}
	
	public Category createCategory(Category category) {
		return categoryRepository.save(category);
	}
	
	public void deleteById(Long id) {
		categoryRepository.deleteById(id);
		
	}
	
	@SuppressWarnings("deprecation")
	public Category updateCategory(Long id, Category category) {
		 Category entityCategory = categoryRepository.getOne(id);
		 updateData(entityCategory, category);
		 return categoryRepository.save(entityCategory);
	}
	
private void updateData(Category entityCategory, Category category) {
		
		entityCategory.setName(category.getName());
		entityCategory.setDescription(category.getDescription());
	
	}
}
