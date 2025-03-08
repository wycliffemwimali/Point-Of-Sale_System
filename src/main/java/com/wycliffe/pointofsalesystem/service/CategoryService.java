package com.wycliffe.pointofsalesystem.service;

import com.wycliffe.pointofsalesystem.entity.CategoryEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface CategoryService {
    CategoryEntity createCategory(CategoryEntity categoryEntity);
    CategoryEntity getCategoryById(Long id);
    List<CategoryEntity> getAllCategories();
    CategoryEntity updateCategory(Long id, CategoryEntity categoryEntity);
    void deleteCategory(Long id);
}
