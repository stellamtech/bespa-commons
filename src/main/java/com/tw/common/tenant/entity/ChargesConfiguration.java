package com.tw.common.tenant.entity;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Where;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@SuppressWarnings("deprecation")
@Entity
@Data
@Table(name = "charges_configuration")
@Where(clause = "deleted=false")
public class ChargesConfiguration {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private boolean isPercentage;

	private double percentageNumber;

	@Column(name = "deleted", nullable = false)
	private Boolean deleted = false;

	@OneToMany(mappedBy = "chargesConfiguration", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ChargesConfigurationChargesMap> chargeMaps = new ArrayList<>(); // Initialize here

	// Getters and Setters
	public List<ChargesConfigurationChargesMap> getChargeMaps() {
		return chargeMaps;
	}

	public void setChargeMaps(List<ChargesConfigurationChargesMap> chargeMaps) {
		this.chargeMaps = chargeMaps;
	}
}