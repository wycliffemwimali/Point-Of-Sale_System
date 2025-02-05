package com.wycliffe.pointofsalesystem.controller;

import com.wycliffe.pointofsalesystem.dto.ItemDto;
import com.wycliffe.pointofsalesystem.entity.ItemEntity;
import com.wycliffe.pointofsalesystem.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/items")
    public ResponseEntity<List<ItemEntity>> getAllItems() {
        List<ItemEntity> itemEntities = itemService.getAllItems();
        if (itemEntities.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(itemEntities);
        }
        return ResponseEntity.status(HttpStatus.OK).body(itemEntities);
    }

    @PostMapping("/items")
    public ResponseEntity<ItemEntity> createItem(@RequestBody ItemDto itemDto) {
        try {
            ItemEntity createdItem = itemService.createItem(itemDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdItem);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("/items/{id}")
    public ResponseEntity<ItemEntity> getItemById(@PathVariable Long id) {
        ItemEntity itemEntity = itemService.getItemById(id);
        if (itemEntity != null) {
            return ResponseEntity.status(HttpStatus.OK).body(itemEntity);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/items/{id}")
    public ResponseEntity<ItemEntity> updateItem(@PathVariable Long id, @RequestBody ItemEntity itemEntity) {
        ItemEntity updatedItem = itemService.updateItem(id, itemEntity);
        if (updatedItem != null) {
            return ResponseEntity.status(HttpStatus.OK).body(updatedItem);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/categories/{id}/items")
    public ResponseEntity<List<ItemEntity>> getItemsByCategory(@PathVariable Long id) {
        List<ItemEntity> items = itemService.getItemsByCategory(id);
        if (items.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(items);
        }
        return ResponseEntity.ok().body(items);
    }

    @DeleteMapping("/items/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        ItemEntity itemEntity = itemService.deleteItem(id);
        if (itemEntity != null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
