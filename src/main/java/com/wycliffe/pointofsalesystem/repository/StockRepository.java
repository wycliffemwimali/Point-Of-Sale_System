package com.wycliffe.pointofsalesystem.repository;

import com.wycliffe.pointofsalesystem.entity.ItemEntity;
import com.wycliffe.pointofsalesystem.entity.StockEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<StockEntity, Long>{
//    @Query("SELECT s FROM StockEntity s JOIN s.items i WHERE i = :itemEntity")
//    List<StockEntity> findStocksByItem(@Param("itemEntity") ItemEntity itemEntity);
    List<StockEntity> findByItemsContaining(ItemEntity itemEntity);


}