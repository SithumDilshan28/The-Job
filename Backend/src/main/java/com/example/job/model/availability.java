package com.example.job.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "availability")
public class availability {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	
	@Column(name = "date")
	private String date;
	
	@Column(name = "timeslot")
	private String timeslot;
	
	@Column(name = "fullname")
	private String fullname;
	
	@Column(name = "imageurl", length = 5000) // Set the length to 5000 characters
    private String imageurl;

	@Column(name = "specilizedjobtype")
	private String specilizedjobtype;
	
	@Column(name = "specilizedcountry")
	private String specilizedcountry;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "email")
	private String email;
	
	

	public availability(long id, String date, String timeslot, String fullname, String imageurl,
			String specilizedjobtype, String specilizedcountry, String phone, String email) {
		super();
		Id = id;
		this.date = date;
		this.timeslot = timeslot;
		this.fullname = fullname;
		this.imageurl = imageurl;
		this.specilizedjobtype = specilizedjobtype;
		this.specilizedcountry = specilizedcountry;
		this.phone = phone;
		this.email = email;
	}



	public availability () {
		
	}


	public long getId() {
		return Id;
	}



	public void setId(long id) {
		Id = id;
	}



	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}
	
	
	public String getFullname() {
		return fullname;
	}



	public void setFullname(String fullname) {
		this.fullname = fullname;
	}



	public String getTimeslot() {
		return timeslot;
	}



	public void setTimeslot(String timeslot) {
		this.timeslot = timeslot;
	}



	public String getImageurl() {
		return imageurl;
	}



	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}



	public String getSpecilizedjobtype() {
		return specilizedjobtype;
	}



	public void setSpecilizedjobtype(String specilizedjobtype) {
		this.specilizedjobtype = specilizedjobtype;
	}



	public String getSpecilizedcountry() {
		return specilizedcountry;
	}



	public void setSpecilizedcountry(String specilizedcountry) {
		this.specilizedcountry = specilizedcountry;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}

	
	
	
}
