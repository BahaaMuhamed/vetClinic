package com.vetclinic.entity;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="PET")
public class Pet implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="PET_ID")
	private Long Pet_id;
	
	@Column(name="PET_NAME")
	private String petName;
	
	@Column(name="PET_GENDER")
	private String petGender;
	
	@Column(name="DATEOFBIRTHDAY")
	private Date dateOfBirthday;
	
	@Column(name="ANIMALKIND")
	private String animalKind;
	
	@Column(name="PHOTO")
	private Blob photo;
	
	@Column(name="WEGIHT")
	private String  wegiht;
	
	@ManyToOne 
	@JoinColumn(name = "OWNER_PET",referencedColumnName="OWNER_ID", nullable = false)
	private Owner owner;

	public Long getPet_id() {
		return Pet_id;
	}

	public void setPet_id(Long pet_id) {
		Pet_id = pet_id;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public String getPetGender() {
		return petGender;
	}

	public void setPetGender(String petGender) {
		this.petGender = petGender;
	}

	

	public Date getDateOfBirthday() {
		return dateOfBirthday;
	}

	public void setDateOfBirthday(Date dateOfBirthday) {
		this.dateOfBirthday = dateOfBirthday;
	}

	public String getAnimalKind() {
		return animalKind;
	}

	public void setAnimalKind(String animalKind) {
		this.animalKind = animalKind;
	}

	public Blob getPhoto() {
		return photo;
	}

	public void setPhoto(Blob photo) {
		this.photo = photo;
	}

	public String getWegiht() {
		return wegiht;
	}

	public void setWegiht(String wegiht) {
		this.wegiht = wegiht;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	
	

}
