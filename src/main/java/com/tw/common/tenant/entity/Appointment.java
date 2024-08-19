package com.tw.common.tenant.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.hibernate.annotations.Where;

import com.tw.common.entity.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("deprecation")
@Entity
@Table(name = "appointments")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Where(clause = "deleted=false") 
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "appointment_date", nullable = false)
	@Temporal(TemporalType.DATE)
	private LocalDate appointmentDate;

	@Column(name = "appointment_time", nullable = false)
	private LocalTime appointmentTime;

	//@ManyToOne(fetch = FetchType.LAZY)
	// @JoinColumn(name = "requested_therapist_id")
	//private User requestedTherapist;
	
	@Column(name = "requested_therapist_id")
	private Long requestedTherapistId;

	//@ManyToOne(fetch = FetchType.LAZY)
	// @JoinColumn(name = "user_id")
	//private User assignedTherapist;
	
	@Column(name = "assigned_therapist_id")
	private Long assignedTherapistId;

	@Column(name = "status", nullable = false)
	@Enumerated(EnumType.STRING)
	private AppointmentStatus status;

	@Column(name = "booking_comment")
	private String bookingComment;

	@Column(name = "merge_services_of_same_therapist")
	private boolean mergeServicesOfSameTherapist;

	@Column(name = "send_booking_info_sms")
	private boolean sendBookingInfoSms;

	@Column(name = "send_booking_info_email")
	private boolean sendBookingInfoEmail;

	@Column(name = "deleted", nullable = false)
	private Boolean deleted = false;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "appointment_services", joinColumns = {
			@JoinColumn(name = "appointment_id") }, inverseJoinColumns = { @JoinColumn(name = "service_id") })
	private List<EServices> services;
}
