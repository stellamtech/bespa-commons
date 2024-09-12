
package com.tw.common.tenant.entity;

import java.io.Serializable;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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

	@Column(name ="level", nullable = false)
	private String levelName;

	@Column(nullable = false)
	private Double price;

	@Column(name = "deleted", nullable = false)
	private Boolean deleted = false;

	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "eService_id")
	@JsonIgnore
	@NotFound(action = NotFoundAction.IGNORE)
	private EServices eService;
}
