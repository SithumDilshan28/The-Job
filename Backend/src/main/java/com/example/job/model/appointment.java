package com.example.job.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "appointment")
public class appointment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	
	@Column(name = "consultantname")
	private String consultantname;
	
	@Column(name = "clientname")
	private String clientname;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "date")
	private String date;
	
	@Column(name = "time")
	private String time;
	
	@Column(name = "clientphone")
	private String clientphone;


	public appointment(long id, String consultantname, String clientname, String email, String date, String time,
			String clientphone) {
		super();
		Id = id;
		this.consultantname = consultantname;
		this.clientname = clientname;
		this.email = email;
		this.date = date;
		this.time = time;
		this.clientphone = clientphone;
	}

	public appointment () {
		
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getConsultantname() {
		return consultantname;
	}

	public void setConsultantname(String consultantname) {
		this.consultantname = consultantname;
	}

	public String getClientname() {
		return clientname;
	}

	public void setClientname(String clientname) {
		this.clientname = clientname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getClientphone() {
		return clientphone;
	}

	public void setClientphone(String clientphone) {
		this.clientphone = clientphone;
	}

	

}
