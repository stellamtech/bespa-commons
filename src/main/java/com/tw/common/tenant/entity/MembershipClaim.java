package com.tw.common.tenant.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import com.tw.generics.AbstractPersistable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "membership_claim")
public class MembershipClaim extends AbstractPersistable {

    private static final long serialVersionUID = 1L;

    @Column(name = "service_name", nullable = false)
    private String serviceName;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "duration_start")
    private LocalTime durationStart;

    @Column(name = "duration_finish")
    private LocalTime durationFinish;

    @Column(name = "healer_name")
    private String healerName;

    @Column(name = "claim", nullable = false)
    private Boolean claim = false;

    @Column(name = "customer_id", nullable = false)
    private Long customerId;

    @Column(name = "membership_id", nullable = false)
    private Long membershipId;
    
    @Column(name = "membership_name", nullable = false)
    private String membershipName;
    
    @Column(name = "purchase_date")
    private LocalDate purchaseDate;
    
    @Column(name = "started_date")
    private LocalDate startedDate;
    
    @Column(name = "ended_date")
    private LocalDate endedDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id", nullable = false)
    private EServices service;

   // @ManyToOne(fetch = FetchType.LAZY)
   // @JoinColumn(name = "therapist_id")
	@Column(name = "therapist_id")
    private Long therapist;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "invoice_id", nullable = false)
    private Invoice invoice;
}