
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity

@Table(name = "history")
public class History implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = -1293136348964357422L;

	@Id

	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "newSalary")
	private int newSalary;

	@Column(name = "DOR")
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date DateOfRevision;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "salary", referencedColumnName = "id", nullable = true)
	private Salary salary;

	
	public History(long id, int newSalary, Date dateOfRevision) {
		super();
		this.id = id;
		this.newSalary = newSalary;
		DateOfRevision = dateOfRevision;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getNewSalary() {
		return newSalary;
	}

	public void setNewSalary(int newSalary) {
		this.newSalary = newSalary;
	}

	public Date getDateOfRevision() {
		return DateOfRevision;
	}

	public void setDateOfRevision(Date dateOfRevision) {
		DateOfRevision = dateOfRevision;
	}

	

}
