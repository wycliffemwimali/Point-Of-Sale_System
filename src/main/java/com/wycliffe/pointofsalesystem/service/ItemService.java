package com.wycliffe.pointofsalesystem.service;

import com.wycliffe.pointofsalesystem.dto.ItemDto;
import com.wycliffe.pointofsalesystem.entity.ItemEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface ItemService {
    List<ItemEntity> getAllItems();
    ItemEntity createItem(ItemDto itemDto);
    ItemEntity getItemById(Long id);
    ItemEntity updateItem(Long id, ItemEntity itemEntity);
    List<ItemEntity> getItemsByCategory(Long id);
    ItemEntity deleteItem(Long id); // Fixed return type
}
