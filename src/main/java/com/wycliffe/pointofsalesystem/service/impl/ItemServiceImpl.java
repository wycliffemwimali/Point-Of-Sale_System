package com.wycliffe.pointofsalesystem.service.impl;


import com.wycliffe.pointofsalesystem.dto.ItemDto;
import com.wycliffe.pointofsalesystem.entity.CategoryEntity;
import com.wycliffe.pointofsalesystem.entity.ItemEntity;
import com.wycliffe.pointofsalesystem.entity.StockEntity;
import com.wycliffe.pointofsalesystem.repository.CategoryRepository;
import com.wycliffe.pointofsalesystem.repository.ItemRepository;
import com.wycliffe.pointofsalesystem.repository.StockRepository;
import com.wycliffe.pointofsalesystem.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private StockRepository stockRepository;

    @Override
    public ItemEntity createItem(ItemDto itemDto) {
        CategoryEntity categoryEntity = categoryRepository.findById(itemDto.getCategoryId()).orElse(null);
        StockEntity stockEntity = stockRepository.findById(itemDto.getStockId()).orElse(null);
        if (categoryEntity!=null && stockEntity!=null) {
            ItemEntity itemEntity = new ItemEntity();
            itemEntity.setName(itemDto.getName());
            itemEntity.setPrice(itemDto.getPrice());
            itemEntity.setCategoryEntity(categoryEntity);
            itemEntity.setStockEntity(stockEntity);
            return itemRepository.save(itemEntity);
        } else {
            return null;
        }
    }

    @Override
    public List<ItemEntity> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public ItemEntity getItemById(Long id) {
        return itemRepository.findById(id).orElse(null);
    }

    @Override
    public List<ItemEntity> getItemsByCategory(Long id) {
        CategoryEntity categoryEntity = categoryRepository.findById(id).orElse(null);
        if (categoryEntity!=null) {
            return itemRepository.findByCategoryEntity(categoryEntity);
        } else {
            return null;
        }
    }

    @Override
    public ItemEntity updateItem(Long id, ItemEntity itemEntity) {
        ItemEntity existingItem = itemRepository.findById(id).orElse(null);
        if (existingItem!=null) {
            existingItem.setName(itemEntity.getName());
            existingItem.setPrice(itemEntity.getPrice());
            // existingItem.setCategoryEntity(itemEntity.getCategoryEntity());
            // existingItem.setStockEntity(itemEntity.getStockEntity());
            return itemRepository.save(existingItem);
        } else {
            return null;
        }
    }

    @Override
    public ItemEntity deleteItem(Long id) {
        ItemEntity item = itemRepository.findById(id).orElse(null);
        if (item != null) {
            itemRepository.delete(item);
        } else {
            // Optionally, throw an exception or log the error
            throw new RuntimeException("Item not found with id: " + id);
        }
        return item;
    }


}