package com.tw.common.tenant.entity;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.Where;

import com.tw.common.entity.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@SuppressWarnings("deprecation")
@Entity
@Table(name = "invoices")
@Where(clause = "deleted=false")
@Data
public class Invoice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@ManyToMany
	@JoinTable(name = "invoice_services", joinColumns = @JoinColumn(name = "invoice_id"), inverseJoinColumns = @JoinColumn(name = "service_id"))
	private List<EServices> services;

//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "user_id")
//	private User user;
	
	@Column(name = "user_id")
	private Long userId;

	@Column(name = "deleted", nullable = false)
	private Boolean deleted = false;

	@OneToMany(mappedBy = "invoice", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Tip> tip;

	private LocalDate date;
	private String invoiceNumber;
	private Double subtotal;
	private Integer discountPercentage;
	private Double discountAmount;
	private Double vat;
	private Double vatAmount;
	private Double total;
	private Double previousDue;
	private String paymentStatus;
	private Double paidAmount = 0.0;

}
