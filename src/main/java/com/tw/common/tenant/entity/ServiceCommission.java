package com.tw.common.tenant.entity;

import com.tw.common.entity.User;

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

@Data
@Entity
@Table(name = "service_commissions")
public class ServiceCommission {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "invoice_id")
	private Invoice invoice;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "service_id")
	private EServices service;

//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "primary_stylist_id")
//	private User primaryStylist;
	
	@Column(name = "primary_stylist_id")
	private Long primaryStylistUserId;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "secondary_stylist_id")
//	private User secondaryStylist;
	
	@Column(name = "secondary_stylist_id")
	private Long secondaryStylistUserId;
	

	@Column(name = "primary_stylist_amount", nullable = false)
    private Double primaryStylistAmount;

    @Column(name = "secondary_stylist_amount")
    private Double secondaryStylistAmount;  // Nullable
}
