package com.badri.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "passenger")
public class Passenger {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "passenger_id")
	private int passenger_id;
	@Column(name = "name", nullable = false)
	private String name;
	@Column(name = "email", nullable = false, unique = true )
	private String email;
	@Column(name = "mobile", nullable = false)
	private String mobile;
	@Column(name = "password", nullable = false)
	private String password;
	@Column(name = "photoname", nullable = false)
	private String photoname;
	@Column(name = "phototype", nullable = false)
	private String phototype;
	@Column(name = "photo", nullable = false)
	private byte[] photo;
	@Transient
	private Long photosize;
	@Transient
	private String confirmpassword;

	public String getConfirmpassword() {
		return confirmpassword;
	}

	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}

	public Long getPhotosize() {
		return photosize;
	}

	public void setPhotosize(Long photosize) {
		this.photosize = photosize;
	}

	public int getPassenger_id() {
		return passenger_id;
	}

	public void setPassenger_id(int passenger_id) {
		this.passenger_id = passenger_id;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhotoname() {
		return photoname;
	}

	public void setPhotoname(String photoname) {
		this.photoname = photoname;
	}

	public String getPhototype() {
		return phototype;
	}

	public void setPhototype(String phototype) {
		this.phototype = phototype;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

}
