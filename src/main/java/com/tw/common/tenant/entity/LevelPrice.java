
package com.tw.common.tenant.entity;

import java.io.Serializable;

import org.hibernate.annotations.Where;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("deprecation")
@Entity
@Table(name = "level_prices")
@Data
@NoArgsConstructor
@Where(clause = "deleted=false")
@AllArgsConstructor
public class LevelPrice implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String level;

	@Column(nullable = false)
	private Double price;

	@Column(name = "deleted", nullable = false)
	private Boolean deleted = false;

	@ManyToOne
	private EServices eService;
}
