package com.wycliffe.pointofsalesystem.controller;

import com.wycliffe.pointofsalesystem.entity.StockEntity;
import com.wycliffe.pointofsalesystem.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class StockController {

    @Autowired
    private StockService stockService;

    @GetMapping("/stocks")
    public ResponseEntity<List<StockEntity>> getAllStocks() {
        List<StockEntity> stocks = stockService.getAllStocks();
        if (stocks.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(stocks);
        }
        return ResponseEntity.status(HttpStatus.OK).body(stocks);
    }

    @PostMapping("/stocks")
    public ResponseEntity<StockEntity> createStock(@RequestBody StockEntity stockEntity) {
        try {
            StockEntity createdStock = stockService.createStock(stockEntity);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdStock);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("/stocks/{id}")
    public ResponseEntity<StockEntity> getStockById(@PathVariable Long id) {
        StockEntity stockEntity = stockService.getStockById(id);
        if (stockEntity != null) {
            return ResponseEntity.status(HttpStatus.OK).body(stockEntity);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/stocks/{id}")
    public ResponseEntity<StockEntity> updateStock(@PathVariable Long id, @RequestBody StockEntity stockEntity) {
        StockEntity updatedStock = stockService.updateStock(id, stockEntity);
        if (updatedStock != null) {
            return ResponseEntity.status(HttpStatus.OK).body(updatedStock);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/items/{id}/stocks")
    public ResponseEntity<List<StockEntity>> getStocksByItem(@PathVariable Long id) {
        List<StockEntity> stocks = stockService.getStocksByItem(id);
        if (stocks.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(stocks);
        }
        return ResponseEntity.ok().body(stocks);
    }

    @DeleteMapping("/stocks/{id}")
    public ResponseEntity<Void> deleteStock(@PathVariable Long id) {
        StockEntity stockEntity = stockService.deleteStock(id);
        if (stockEntity != null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
