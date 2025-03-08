package com.wycliffe.pointofsalesystem.service.impl;


import com.wycliffe.pointofsalesystem.dto.CheckoutDto;
import com.wycliffe.pointofsalesystem.entity.CheckoutEntity;
import com.wycliffe.pointofsalesystem.entity.ItemEntity;
import com.wycliffe.pointofsalesystem.entity.StockEntity;
import com.wycliffe.pointofsalesystem.repository.CheckoutRepository;
import com.wycliffe.pointofsalesystem.repository.ItemRepository;
import com.wycliffe.pointofsalesystem.repository.StockRepository;
import com.wycliffe.pointofsalesystem.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    @Autowired
    private CheckoutRepository checkoutRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private StockRepository stockRepository;

    @Override
    public CheckoutEntity createCheckout(CheckoutDto checkoutDto) {
        List<Long> itemIds = checkoutDto.getItems();
        Set<ItemEntity> items = new HashSet<>();
        Double total = 0.0;

        for (Long itemId : itemIds) {
            ItemEntity item = itemRepository.findById(itemId).orElse(null);
            if (item != null) {
                items.add(item);
                total += item.getPrice();
                StockEntity stock = item.getStockEntity();
                if (stock != null) {
                    int currentQty = stock.getQty();
                    if (currentQty > 0) {
                        stock.setQty(currentQty - 1);
                        stockRepository.save(stock);
                    } else {
                        throw new RuntimeException("Item out of stock: " + item.getName());
                    }
                }
            }
        }

        LocalDateTime dateTime = LocalDateTime.now();
        CheckoutEntity checkout = new CheckoutEntity();
        checkout.setTotal(total);
        checkout.setOrderTime(dateTime);
        checkout.setItems(items); // Directly set the items set here

        return checkoutRepository.save(checkout);
    }


    @Override
    public List<CheckoutEntity> getAllCheckouts() {
        return checkoutRepository.findAll();
    }

    @Override
    public CheckoutEntity getCheckoutById(Long id) {
        return checkoutRepository.findById(id).orElse(null);
    }

    @Override
    public CheckoutEntity deleteCheckout(Long id) {
        CheckoutEntity checkout = checkoutRepository.findById(id).orElse(null);
        if (checkout != null) {
            checkoutRepository.delete(checkout);
        } else {
            // Optionally, throw an exception if the checkout doesn't exist
            throw new RuntimeException("Checkout not found with id: " + id);
        }
        return checkout;
    }


}