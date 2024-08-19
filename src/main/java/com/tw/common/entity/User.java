package com.tw.common.entity;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tw.generics.AbstractPersistable;
import com.tw.generics.StatusType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@SuppressWarnings("deprecation")
@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
@Where(clause = "deleted=false")
public class User extends AbstractPersistable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "middle_name")
	private String middleName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "fullname")
	private String fullName;

	@Column(name = "user_name" , nullable = false)
	private String userName;

	@Column(name = "email")
	private String email;

	@Column(name = "password" , nullable = false)
	private String password;

	@Column(name = "address")
	private String address;

	@Column(name = "mobile_no")
	private String mobileNo;

	@Column(name = "salary")
	private double salary;

	@Column(name = "join_date")
	private Date joinDate;
	
	@Column(name = "status", nullable = true)
	private String status = StatusType.Active.getValue();
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_role", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
	@JoinColumn(name = "role_id") })
	@JsonIgnore
	private List<Role> roles;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tenant_id", nullable = false)
	private MasterTenant tenant;

	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

}
