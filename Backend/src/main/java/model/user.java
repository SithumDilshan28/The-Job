package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
@Entity
@Table (name = "user")

public class user {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	@Column(name = "firstName")
    private String firstName;
	
	@Column(name = "lastName")
    private String lastName;
	
	@Column(name = "dob")
    private String dob;
	
	@Column(name = "sex")
    private String sex;
	
	@Column(name = "maritalStatus")
    private String maritalStatus;
	
	@Column(name = "nic")
    private String nic;
	
	@Column(name = "city")
    private String city;
	
	@Column(name = "email")
    private String email;
	
	@Column(name = "phoneNumber")
    private String phoneNumber;
	
	@Column(name = "highestEducation")
    private String highestEducation;
	
	@Column(name = "college")
    private String college;
	
	@Column(name = "companyName")
    private String companyName;
	
	@Column(name = "jobPosition")
    private String jobPosition;

    @Lob
    @Column(name = "cv")
    private byte[] cv; // Store PDF data as a byte array

	public user(Long id, String firstName, String lastName, String dob, String sex, String maritalStatus, String nic,
			String city, String email, String phoneNumber, String highestEducation, String college, String companyName,
			String jobPosition, byte[] cv) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.sex = sex;
		this.maritalStatus = maritalStatus;
		this.nic = nic;
		this.city = city;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.highestEducation = highestEducation;
		this.college = college;
		this.companyName = companyName;
		this.jobPosition = jobPosition;
		this.cv = cv;
	}
    
	public user() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getNic() {
		return nic;
	}

	public void setNic(String nic) {
		this.nic = nic;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getHighestEducation() {
		return highestEducation;
	}

	public void setHighestEducation(String highestEducation) {
		this.highestEducation = highestEducation;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getJobPosition() {
		return jobPosition;
	}

	public void setJobPosition(String jobPosition) {
		this.jobPosition = jobPosition;
	}

	public byte[] getCv() {
		return cv;
	}

	public void setCv(byte[] cv) {
		this.cv = cv;
	}
    
}
