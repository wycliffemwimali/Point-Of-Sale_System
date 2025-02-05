package com.wycliffe.pointofsalesystem.service;

import com.wycliffe.pointofsalesystem.dto.CheckoutDto;
import com.wycliffe.pointofsalesystem.entity.CheckoutEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface CheckoutService {
    List<CheckoutEntity> getAllCheckouts();
    CheckoutEntity getCheckoutById(Long id);
    CheckoutEntity createCheckout(CheckoutDto checkoutDto);
    CheckoutEntity deleteCheckout(Long id); // Fixed return type
}
