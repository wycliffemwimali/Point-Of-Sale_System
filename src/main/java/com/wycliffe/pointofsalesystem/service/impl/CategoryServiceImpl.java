package com.wycliffe.pointofsalesystem.service.impl;


import com.wycliffe.pointofsalesystem.entity.CategoryEntity;
import com.wycliffe.pointofsalesystem.repository.CategoryRepository;
import com.wycliffe.pointofsalesystem.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public CategoryEntity createCategory(CategoryEntity categoryEntity) {
        return categoryRepository.save(categoryEntity);
    }

    @Override
    public List<CategoryEntity> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public CategoryEntity getCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public CategoryEntity updateCategory(Long id, CategoryEntity categoryEntity) {
        CategoryEntity existCategory = categoryRepository.findById(id).orElse(null);
        if (existCategory != null) {
            if (categoryEntity.getName() != null) {
                existCategory.setName(categoryEntity.getName());
            }
            categoryRepository.save(existCategory);
            return existCategory;
        } else {
            return null;
        }
    }


    @Override
    public void deleteCategory(Long id) {
        CategoryEntity category = categoryRepository.findById(id).orElse(null);
        if (category != null) {
            categoryRepository.delete(category);
        }
    }



}