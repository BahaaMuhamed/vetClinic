package com.vetclinic.entity;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.web.bind.annotation.Mapping;

@Entity
@Table(name="CLINIC")
public class Clinic implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CLINIC_ID")
	private Long clinicId;
	
	@Column(name="CLINIC_NAME")
	private String  clinicName;
	
	@Column(name="CLINIC_ADDERSS")
	private String clinikAdderss;
	
	
	@Column(name="CLINIC_PHONE")
	private String  clinicPhone;
	
	@Column(name="CLINIC_WORKE_DAYS")
	private String clinicWorkDays;
	
	@Column(name="CLINIC_WORKE_HOURE")
	private String clinicWorkHoure;
	
	@Column(name="CLINICEMAIL")
	private String clinicEmail;
	
	@Column(name="SOCIALNETWORKSURLS")
	private String  socialNetworksURLs;
	
	/*@OneToMany(mappedBy="clinc",fetch=FetchType.LAZY)
	private List<Doctor> doctors;*/

	

	public Long getClinicId() {
		return clinicId;
	}

	public void setClinicId(Long clinicId) {
		this.clinicId = clinicId;
	}

	public String getClinicName() {
		return clinicName;
	}

	public void setClinicName(String clinicName) {
		this.clinicName = clinicName;
	}

	public String getClinikAdderss() {
		return clinikAdderss;
	}

	public void setClinikAdderss(String clinikAdderss) {
		this.clinikAdderss = clinikAdderss;
	}

	public String getClinicPhone() {
		return clinicPhone;
	}

	public void setClinicPhone(String clinicPhone) {
		this.clinicPhone = clinicPhone;
	}

	public String getClinicWorkDays() {
		return clinicWorkDays;
	}

	public void setClinicWorkDays(String clinicWorkDays) {
		this.clinicWorkDays = clinicWorkDays;
	}

	public String getClinicWorkHoure() {
		return clinicWorkHoure;
	}

	public void setClinicWorkHoure(String clinicWorkHoure) {
		this.clinicWorkHoure = clinicWorkHoure;
	}

	public String getClinicEmail() {
		return clinicEmail;
	}

	public void setClinicEmail(String clinicEmail) {
		this.clinicEmail = clinicEmail;
	}

	public String getSocialNetworksURLs() {
		return socialNetworksURLs;
	}

	public void setSocialNetworksURLs(String socialNetworksURLs) {
		this.socialNetworksURLs = socialNetworksURLs;
	}

	/*public List<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}*/


}
