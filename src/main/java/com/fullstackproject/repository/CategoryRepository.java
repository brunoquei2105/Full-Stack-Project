package com.fullstackproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fullstackproject.domain.Category;

public interface CategoryRepository extends JpaRepository<Category,Long>{

}
