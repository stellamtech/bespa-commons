package com.tw.common.tenant.entity;

import java.time.LocalDate;

import org.hibernate.annotations.Where;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@SuppressWarnings("deprecation")
@Data
@Entity
@Table(name = "gift_cards")
@Where(clause = "deleted=false")
public class GiftCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;
    
    @Column(name = "deleted")
    private boolean deleted=false;

    private Double amount;

    private LocalDate expiryDate;

    private Boolean isRedeemed = false;

}
