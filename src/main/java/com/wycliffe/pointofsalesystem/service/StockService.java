package com.wycliffe.pointofsalesystem.service;

import com.wycliffe.pointofsalesystem.entity.StockEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface StockService {
    List<StockEntity> getAllStocks();
    StockEntity createStock(StockEntity stockEntity);
    StockEntity getStockById(Long id);
    StockEntity updateStock(Long id, StockEntity stockEntity);
    List<StockEntity> getStocksByItem(Long id);
    StockEntity deleteStock(Long id); // Fixed return type
}
