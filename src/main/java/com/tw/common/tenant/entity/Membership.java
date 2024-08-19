package com.tw.common.tenant.entity;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.Where;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("deprecation")
@Table(name = "memberships")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Where(clause = "deleted=false")
public class Membership {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String description;

	@Column(nullable = false)
	private Double price;

	@Column(nullable = false)
	private int durationInMonths;

	@Column(nullable = false)
	private LocalDate startDate;

	@Column(nullable = false)
	private LocalDate endDate;

	@Column(name = "is_active")
	private boolean isActive = true;
	
	@Column(name = "deleted", nullable = false)
	private Boolean deleted = false;

	public boolean isExpired() {
		LocalDate currentDate = LocalDate.now();
		return currentDate.isAfter(this.endDate);
	}

	@OneToMany(mappedBy = "membership")
	private List<Customer> customer;

}