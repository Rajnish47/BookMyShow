package dev.rajnish.BookMyShow.model;

import java.time.LocalDateTime;

import dev.rajnish.BookMyShow.model.constant.PaymentMode;
import dev.rajnish.BookMyShow.model.constant.PaymentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Payment extends BaseModel {

    private double amount;
    private LocalDateTime paymenTime;
    private String referanceId;

    @ManyToOne
    private Ticket ticket;

    private PaymentStatus paymentStatus;
    private PaymentMode paymentMode;
    
}
