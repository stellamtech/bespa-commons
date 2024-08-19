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
@Table(name = "charges_configuration_charges_map")
public class ChargesConfigurationChargesMap {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "charges_configuration_id")
    private ChargesConfiguration chargesConfiguration;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private EServices service;

    @Column(name = "charge_amount")
    private Double chargeAmount;
}
