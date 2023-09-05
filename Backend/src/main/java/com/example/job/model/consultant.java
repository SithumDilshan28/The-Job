package com.example.job.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "consultant")
public class consultant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	
	@Column(name = "fullname")
	private String fullname;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;

	@Column(name = "nic")
	private String nic;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "specilizedcountry")
	private String specilizedcountry;
	
	@Column(name = "specilizedjobtype")
	private String specilizedjobtype;
	
	@Column(name = "imageurl", length = 5000) // Set the length to 5000 characters
	private String imageurl;
	

	public consultant(long id, String fullname, String email, String password, String nic, String phone, String address,
			String specilizedcountry, String specilizedjobtype, String imageurl) {
		super();
		Id = id;
		this.fullname = fullname;
		this.email = email;
		this.password = password;
		this.nic = nic;
		this.phone = phone;
		this.address = address;
		this.specilizedcountry = specilizedcountry;
		this.specilizedjobtype = specilizedjobtype;
		this.imageurl = imageurl;
	}


	public consultant () {
		
	}


	public long getId() {
		return Id;
	}


	public void setId(long id) {
		Id = id;
	}


	public String getFullname() {
		return fullname;
	}


	public void setFullname(String fullname) {
		this.fullname = fullname;
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


	public String getNic() {
		return nic;
	}


	public void setNic(String nic) {
		this.nic = nic;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getSpecilizedcountry() {
		return specilizedcountry;
	}


	public void setSpecilizedcountry(String specilizedcountry) {
		this.specilizedcountry = specilizedcountry;
	}


	public String getSpecilizedjobtype() {
		return specilizedjobtype;
	}


	public void setSpecilizedjobtype(String specilizedjobtype) {
		this.specilizedjobtype = specilizedjobtype;
	}


	public String getImageurl() {
		return imageurl;
	}


	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}

	
 }
