package com.wycliffe.pointofsalesystem.controller;

import com.wycliffe.pointofsalesystem.dto.CheckoutDto;
import com.wycliffe.pointofsalesystem.entity.CheckoutEntity;
import com.wycliffe.pointofsalesystem.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class CheckoutController {

    @Autowired
    private CheckoutService checkoutService;

    @GetMapping("/checkouts")
    public ResponseEntity<List<CheckoutEntity>> getAllCheckouts() {
        List<CheckoutEntity> checkouts = checkoutService.getAllCheckouts();
        return ResponseEntity.status(200).body(checkouts);
    }

    @GetMapping("/checkouts/{id}")
    public ResponseEntity<CheckoutEntity> getCheckoutById(@PathVariable Long id) {
        CheckoutEntity checkoutEntity = checkoutService.getCheckoutById(id);
        if (checkoutEntity != null) {
            return ResponseEntity.status(200).body(checkoutEntity);
        } else {
            return ResponseEntity.status(404).body(null);
        }
    }

    @PostMapping("/checkouts")
    public ResponseEntity<CheckoutEntity> createCheckout(@RequestBody CheckoutDto checkoutDto) {
        CheckoutEntity checkoutEntity = checkoutService.createCheckout(checkoutDto);
        return ResponseEntity.status(201).body(checkoutEntity);
    }

    @DeleteMapping("/checkouts/{id}")
    public ResponseEntity<Void> deleteCheckout(@PathVariable Long id) {
        CheckoutEntity checkoutEntity = checkoutService.deleteCheckout(id);
        if (checkoutEntity != null) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(404).build();
        }
    }
}
