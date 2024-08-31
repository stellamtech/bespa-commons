package com.tw.common.tenant.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.experimental.Accessors;

@SuppressWarnings("deprecation")
@Data
@Entity
@Accessors(chain = true)
@Table(name = "e_services")
@Where(clause = "deleted=false")
public class EServices implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;

	@Column(name = "created_at")
	private Timestamp createdAt;

	@Lob
	private String description;

	@Column(length = 255, nullable = false)
	private String name;

	@Column(name = "deleted", nullable = false)
	private Boolean deleted = false;

	@Column(nullable = false)
	private double price;

	@Column(name = "service_frequency")
	private int serviceFrequency;

	@Column(name = "cost")
	private double cost;

	@Column(name = "fixed")
	private boolean fixed;

	@Column(name = "is_online")
	private boolean isOnline;

	@Column(name = "gender")
	private String gender;

	@Column(name = "start")
	private int start;

	@Column(name = "process")
	private int process;

	@Column(name = "finish")
	private int finish;

	@Column(length = 16)
	private int totalServiceDuration;

	@ManyToOne
	@JoinColumn(name = "parent_id")
	private EServices parentServices;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "category_id")
	@JsonIgnore
	@NotFound(action = NotFoundAction.IGNORE)
	private Categories categories;

	@OneToMany(mappedBy = "eService", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private List<LevelPrice> levelPrices;

//	@ManyToMany(fetch = FetchType.LAZY)
//	@JoinTable(name = "user_eservices", joinColumns = { @JoinColumn(name = "eservices_id") }, inverseJoinColumns = {
//	@JoinColumn(name = "user_id") })
//	@JsonIgnore
//	private List<User> user;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "user_eservices", 
	     joinColumns = @JoinColumn(name = "eservices_id"))
	@Column(name = "user_id")
	private List<Long> user;

	@PrePersist
	protected void onCreate() {
		this.createdAt = new Timestamp(System.currentTimeMillis());
	}
}
