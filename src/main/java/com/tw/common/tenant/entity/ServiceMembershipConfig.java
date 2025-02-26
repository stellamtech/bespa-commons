package com.tw.common.tenant.entity;

import java.time.LocalDate;

import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tw.generics.AbstractPersistable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@SuppressWarnings("deprecation")
@Data
@Entity
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@Table(name = "service_membership_config")
@Where(clause = "deleted=false")
public class ServiceMembershipConfig extends AbstractPersistable {
	/**
	 * Taufeeq
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "e_service_id", nullable = false)
	private EServices eService;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "map_e_service_id", nullable = false)
	@JsonIgnore
	private EServices mapEService;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id", nullable = false)
	private Categories category;
	
	private Integer quantity;

	@Column(name = "started", nullable = false)
	private LocalDate started;

	@Column(name = "ended", nullable = false)
	private LocalDate ended;
	
	@Column(name = "validity", nullable = false)
	private Integer validity;

}
