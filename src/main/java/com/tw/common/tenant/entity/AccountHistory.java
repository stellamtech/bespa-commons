package com.tw.common.tenant.entity;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tw.generics.AbstractPersistable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("deprecation")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "account_history")
@org.hibernate.annotations.Where(clause = "deleted=false")
public class AccountHistory extends AbstractPersistable {

	/**
	 * Taufeeq
	 **/
	private static final long serialVersionUID = 3497039430823725529L;
	
	@Column(name = "voucher_no", nullable = true)
	private String voucherNo;

	@Column(name = "type", nullable = true)
	private String type;

	@Column(name = "amount", nullable = true)
	private double amount;

	@Column(name = "status", nullable = true)
	private String status;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "invoice_id")
	@JsonIgnore
	@NotFound(action = NotFoundAction.IGNORE)
	private Invoice invoice;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "payment_id")
	@JsonIgnore
	@NotFound(action = NotFoundAction.IGNORE)
	private Payment payment;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "payment_method_id")
	@JsonIgnore
	@NotFound(action = NotFoundAction.IGNORE)
	private PaymentMethod paymentMethodId;

}
