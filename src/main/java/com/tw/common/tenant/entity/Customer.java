package com.tw.common.tenant.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.Where;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("deprecation")
@Entity
@Table(name = "customers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Where(clause = "deleted=false")
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;

	@Column(nullable = false)
	private String firstName;

	@Column(nullable = false)
	private String lastName;

	@Column(name = "deleted", nullable = false)
	private Boolean deleted = false;

	@Column(nullable = false, unique = true)
	// @Pattern( regexp = "[0-9]{9}", message = "Please enter valid mobile phone")
	// @NotBlank( message = "Mobile phone cannot be empty")
	private String phone;

	private String email;
	private String gender;
	private LocalDate dob;
	private LocalDate anniversary;
	private String state;
	private String address;
	private String taxNumber;
	private boolean promotionSms;
	private boolean promotionEmail;
	private boolean transactionSms;
	private boolean transactionEmail;
	private String leadSource;
	private String sourceDesc;
	private boolean customerReferral;

	@OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
	private List<Appointment> appointments;
	
//	@OneToOne
//	@JoinColumn(name = "membership_id")
//	private Membership membership;
	
	@ManyToOne
    @JoinColumn(name = "membership_id")
    private Membership membership;

}
