package com.example.demo.Definitions;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "employee")
@Valid
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2050173409084711159L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long empId;

	@Column(name = "name")
	private String name;
	@Column(name = "experience")
	private int experience;
	@Column(name = "address")
	private String address;
	@Column(name = "phone_number")
	private long phoneNumber;
	@Column(name = "nationality")
	private String nationality;
	@Column(name = "martial_status")
	private String martialStatus;
	@Column(name = "education")
	private String education;
	@Column(name = "blood_group")
	private String bloodGroup;
	@Column(name = "DOJ")
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date dateOfJoin;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "salary", referencedColumnName = "id", nullable = true)
	private Salary salary;

	public Employee() {

	}

	public Employee(String name, int experience, String address, long phone_number, String nationality,
			String martial_status, String education, String blood_group, long empId, Date dateOfJoin) {
		super();
		this.empId = empId;
		this.name = name;
		this.experience = experience;
		this.address = address;
		this.phoneNumber = phone_number;
		this.nationality = nationality;
		this.martialStatus = martial_status;
		this.education = education;
		this.bloodGroup = blood_group;
		this.dateOfJoin = dateOfJoin;

	}

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getPhone_number() {
		return phoneNumber;
	}

	public void setPhone_number(long phone_number) {
		this.phoneNumber = phone_number;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getMartial_status() {
		return martialStatus;
	}

	public void setMartial_status(String martial_status) {
		this.martialStatus = martial_status;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getBlood_group() {
		return bloodGroup;
	}

	public void setBlood_group(String blood_group) {
		this.bloodGroup = blood_group;
	}

	public Date getDateOfJoin() {
		return dateOfJoin;
	}

	public void setDateOfJoin(Date dateOfJoin) {
		this.dateOfJoin = dateOfJoin;

	}
}