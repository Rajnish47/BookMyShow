package dev.rajnish.BookMyShow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.rajnish.BookMyShow.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Integer> {
    
}
