package com.example.job.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "job")
public class job {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	
	@Column(name = "role")
	private String role;
	
	@Column(name = "company")
	private String company;
	
	@Column(name = "experience")
	private String experience;
	
	@Column(name = "country")
	private String country;

	@Column(name = "salary")
	private String salary;
	
	@Column(name = "category")
	private String category;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "imageurl", length = 5000) // Set the length to 5000 characters
	private String imageurl;
	

	
	public job(long id, String role, String company, String experience, String country, String salary, String category,
			String type, String status, String imageurl) {
		super();
		Id = id;
		this.role = role;
		this.company = company;
		this.experience = experience;
		this.country = country;
		this.salary = salary;
		this.category = category;
		this.type = type;
		this.status = status;
		this.imageurl = imageurl;
	}


	public job () {
		
	}


	public long getId() {
		return Id;
	}


	public void setId(long id) {
		Id = id;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public String getCompany() {
		return company;
	}


	public void setCompany(String company) {
		this.company = company;
	}


	public String getExperience() {
		return experience;
	}


	public void setExperience(String experience) {
		this.experience = experience;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getSalary() {
		return salary;
	}


	public void setSalary(String salary) {
		this.salary = salary;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getImageurl() {
		return imageurl;
	}


	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}
	
}
