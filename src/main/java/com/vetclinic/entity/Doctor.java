package com.vetclinic.entity;

import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="DOCTOR")
public class Doctor implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="DOCTOR_ID")
	private Long doctorId;
	
	@Column(name="DOCTOR_NAME")
	private String  doctorName;
	
	@Column(name="DOCTOR_PHONE")
	private String doctorPhone;
	
	@Column(name="DOCTOR_PHOTO")
	private Blob doctorPhoto;
	
	@Column(name="DOCTOR_BIO")
	private Blob doctorBio;
	
	@ManyToOne
	@JoinColumn(name="CLINIC",referencedColumnName="CLINIC_ID")
	private Clinic clinc;

	public Long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	

	public String getDoctorPhone() {
		return doctorPhone;
	}

	public void setDoctorPhone(String doctorPhone) {
		this.doctorPhone = doctorPhone;
	}

	public Blob getDoctorPhoto() {
		return doctorPhoto;
	}

	public void setDoctorPhoto(Blob doctorPhoto) {
		this.doctorPhoto = doctorPhoto;
	}

	public Blob getDoctorBio() {
		return doctorBio;
	}

	public void setDoctorBio(Blob doctorBio) {
		this.doctorBio = doctorBio;
	}

	public Clinic getClinc() {
		return clinc;
	}

	public void setClinc(Clinic clinc) {
		this.clinc = clinc;
	}

	
	
	

}
