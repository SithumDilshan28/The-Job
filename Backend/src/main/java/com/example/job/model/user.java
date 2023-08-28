package com.example.job.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class user {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	
	@Column(name = "firstname")
	private String firstname;
	
	@Column(name = "lastname")
	private String lastname;
	
	@Column(name = "nic")
	private String nic;
	
	@Column(name = "dob")
	private String dob;

	@Column(name = "sex")
	private String sex;
	
	@Column(name = "maritalstatus")
	private String maritalstatus;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "phone")
	private String phone;

	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "education")
	private String education;
	
	@Column(name = "college")
	private String college;
	
	@Column(name = "job")
	private String job;

	@Column(name = "role")
	private String role;

	public user(long id, String firstname, String lastname, String nic, String dob, String sex, String maritalstatus,
			String address, String phone, String email, String password, String education, String college, String job,
			String role) {
		super();
		Id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.nic = nic;
		this.dob = dob;
		this.sex = sex;
		this.maritalstatus = maritalstatus;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.education = education;
		this.college = college;
		this.job = job;
		this.role = role;
	}
	
	
	public user () {
		
	}


	public long getId() {
		return Id;
	}


	public void setId(long id) {
		Id = id;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getNic() {
		return nic;
	}


	public void setNic(String nic) {
		this.nic = nic;
	}


	public String getDob() {
		return dob;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public String getMaritalStatus() {
		return maritalstatus;
	}


	public void setMaritalStatus(String maritalStatus) {
		this.maritalstatus = maritalStatus;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
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


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEducation() {
		return education;
	}


	public void setEducation(String education) {
		this.education = education;
	}


	public String getCollege() {
		return college;
	}


	public void setCollege(String college) {
		this.college = college;
	}


	public String getJob() {
		return job;
	}


	public void setJob(String job) {
		this.job = job;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}

}
