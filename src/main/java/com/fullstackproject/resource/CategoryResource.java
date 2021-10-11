package com.fullstackproject.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fullstackproject.domain.Category;
import com.fullstackproject.service.CategoryService;


@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
	
	@Autowired
	private  CategoryService categoryService;
	
	@GetMapping
	public ResponseEntity<List<Category>> getAll(){
		List<Category> categories = categoryService.findAll();
		return ResponseEntity.ok().body(categories);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> getById(@PathVariable Long id){
	Category category = categoryService.findById(id);
		return ResponseEntity.ok().body(category);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id){
		categoryService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping
	public ResponseEntity<Category> postCategory(@RequestBody Category category){
			category = categoryService.createCategory(category);
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
					buildAndExpand(category.getCodeCategoryLong()).toUri();
			return ResponseEntity.created(uri).body(category);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Category> putCategoryById(@PathVariable Long id, 
			@RequestBody Category category){
		category = categoryService.updateCategory(id, category);
		return ResponseEntity.ok().body(category);
	}
	
	
	

}
