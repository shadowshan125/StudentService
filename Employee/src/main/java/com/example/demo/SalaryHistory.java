package com.example.demo;


import java.io.Serializable;
import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "SalaryHistory")
public class SalaryHistory implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name="newSalary")
	private Integer newSalary;
	@Column(name="oldSalary")
	private Integer oldSalary;
	@Column(name = "nsd")
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date dateOfIncrement;
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public Integer getNewSalary() {
		return newSalary;
	}
	public void setNewSalary(Integer newSalary) {
		this.newSalary = newSalary;
	}
	public Integer getOldSalary() {
		return oldSalary;
	}
	public void setOldSalary(Integer oldSalary) {
		this.oldSalary = oldSalary;
	}
	public Date getDateOfIncrement() {
		return dateOfIncrement;
	}
	public void setDateOfIncrement(Date dateOfIncrement) {
		this.dateOfIncrement = dateOfIncrement;
	}

	
	
}
