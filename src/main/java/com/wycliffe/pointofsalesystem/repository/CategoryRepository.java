package com.wycliffe.pointofsalesystem.repository;

import com.wycliffe.pointofsalesystem.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long>{
    boolean existsByName(String name);
}