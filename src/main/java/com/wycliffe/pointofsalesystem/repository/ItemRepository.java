package com.wycliffe.pointofsalesystem.repository;

import com.wycliffe.pointofsalesystem.entity.CategoryEntity;
import com.wycliffe.pointofsalesystem.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Long>{
//    @Query("SELECT p FROM ItemEntity p WHERE p.categoryEntity = :categoryEntity")
//    List<ItemEntity> findItemsByCategory(@Param("categoryEntity") CategoryEntity categoryEntity);
    List<ItemEntity> findByCategoryEntity(CategoryEntity categoryEntity);

}