package com.wycliffe.pointofsalesystem.repository;

import com.wycliffe.pointofsalesystem.entity.CheckoutEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckoutRepository extends JpaRepository<CheckoutEntity, Long>{
    
}