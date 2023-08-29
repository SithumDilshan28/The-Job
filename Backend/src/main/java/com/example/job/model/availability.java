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

	public availability(long id, String date, String timeslot) {
		super();
		Id = id;
		this.date = date;
		this.timeslot = timeslot;
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

	public String getTimeslot() {
		return timeslot;
	}

	public void setTimeslot(String timeslot) {
		this.timeslot = timeslot;
	}
	
}
