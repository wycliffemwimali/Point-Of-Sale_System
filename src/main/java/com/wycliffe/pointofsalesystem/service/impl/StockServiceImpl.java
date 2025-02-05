package com.wycliffe.pointofsalesystem.service.impl;


import com.wycliffe.pointofsalesystem.entity.ItemEntity;
import com.wycliffe.pointofsalesystem.entity.StockEntity;
import com.wycliffe.pointofsalesystem.repository.ItemRepository;
import com.wycliffe.pointofsalesystem.repository.StockRepository;
import com.wycliffe.pointofsalesystem.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public StockEntity createStock(StockEntity stockEntity) {
        return stockRepository.save(stockEntity);
    }

    @Override
    public List<StockEntity> getAllStocks() {
        return stockRepository.findAll();
    }

    @Override
    public StockEntity getStockById(Long id) {
        return stockRepository.findById(id).orElse(null);
    }

    @Override
    public List<StockEntity> getStocksByItem(Long id) {
        ItemEntity itemEntity = itemRepository.findById(id).orElse(null);
        if (itemEntity!=null) {
            return stockRepository.findByItemsContaining(itemEntity);
        } else {
            return null;
        }
    }

    @Override
    public StockEntity updateStock(Long id, StockEntity stockEntity) {
        StockEntity existingStock = stockRepository.findById(id).orElse(null);
        if (existingStock!=null) {
            existingStock.setName(stockEntity.getName());
            existingStock.setQty(stockEntity.getQty());
            stockRepository.save(existingStock);
            return existingStock;
        } else {
            return null;
        }
    }


    @Override
    public void deleteStock(Long id) {
        StockEntity stock = stockRepository.findById(id).orElse(null);
        if (stock != null) {
            stockRepository.delete(stock);
        } else {
            // Optionally, throw an exception or log the error
            throw new RuntimeException("Stock not found with id: " + id);
        }
    }

}