package com.tw.common.entity;


import org.hibernate.annotations.Where;

import com.tw.generics.AbstractPersistable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@EqualsAndHashCode(callSuper=false)
@Table(name="tenant_master")
@Where(clause = "deleted=false")
public class MasterTenant extends AbstractPersistable {

	/**
	 * @author BILAL
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "db_name", nullable = false)
	private String dbName;

	@Column(name = "tenant_name", nullable = false)
	private String tenantName;

	@Column(name = "url", nullable = false)
	private String url;

	@Column(name = "user_name", nullable = false)
	private String userName;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "driver_class", nullable = false)
	private String driverClass;

	@Column(name = "status", nullable = false)
	private String status;
	
	@Column(name = "alias_name", nullable = false)
	private String aliasName;
	
	@Column(name = "first_mobile_no", nullable = false, unique = true)
	private String firstMobileNo;
	
	@Column(name = "second_mobile_no", unique = true)
	private String secondMobileNo;

	@Column(name = "gst_no")
	private String gstNo;
	
	@Column(name = "address", nullable = false)
	private String address;
	
	@Column(name = "tenant_id")
	private Integer tenantId;

}
