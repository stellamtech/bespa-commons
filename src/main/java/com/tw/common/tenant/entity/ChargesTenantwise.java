package com.tw.common.tenant.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "charges_tenantwise")
public class ChargesTenantwise {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "tenant_id")
	private Long tenantId;

	@ManyToOne
	@JoinColumn(name = "charges_configuration_charges_map_id")
	private ChargesConfigurationChargesMap chargesMap;
	
}
