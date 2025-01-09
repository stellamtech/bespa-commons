package com.tw.common.tenant.entity;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@JsonBackReference
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@ManyToMany
	@JoinTable(name = "invoice_services", joinColumns = @JoinColumn(name = "invoice_id"), inverseJoinColumns = @JoinColumn(name = "service_id"))
	private List<EServices> services;
	
	@Column(name = "user_id")
	private Long userId;

	@Column(name = "deleted", nullable = false)
	private Boolean deleted = false;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "tip_id")
	private Tip tip;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "payment_method_id")
	private PaymentMethod paymentMethod;

	private LocalDate date;
	private String invoiceNumber;
	private Double subtotal;
	private Double discountPercentage;
	private Double discountFlatAmount;
	private Double discountAmount;
	private Double netAmount;
	private Double vatPercentage;
	private Double vatAmount;
	private Double total;
	private Double grandTotal;
	private Double previousDue;
	private String paymentStatus;
	private Double paidAmount = 0.0;
	private Double balance;
	
	@OneToMany(mappedBy = "invoice", fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JsonIgnore
	private List<InvoiceSlave> invoiceSlave;
	
	@Override
    public int hashCode() {
        return Objects.hash(id);
    }
	
}
