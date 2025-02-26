package com.tw.common.entity;

import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tw.generics.AbstractPersistable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@SuppressWarnings("deprecation")
@Entity
@Data // Generates getters, setters, toString, equals, and hashCode methods
@NoArgsConstructor // Generates a no-args constructor
@AllArgsConstructor // Generates an all-args constructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "branch")
@Where(clause = "deleted=false")
public class Branch extends AbstractPersistable {

	/**
	 * Taufeeq
	 */
	private static final long serialVersionUID = 1L;


	@Column(name = "branch_name", nullable = false)
	private String branchName;
	
	@Column(name = "branch_code")
	private String branchCode;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tenant_id", nullable = false)
	@JsonIgnore
	private MasterTenant masterTenant;

}
