package com.example.demo.Definitions;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "Salary")
public class Salary implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -215662169696353718L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@OneToOne(mappedBy = "salary", cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Employee employee;

	private Salary salary;
	
	

	/*
	 * @Column(name = "salary1") private String salary1;
	 */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Salary getSalary() {
		return salary;
	}

	public void setSalary(Salary salary) {
		this.salary = salary;
	}

	/*
	 * @MapsId // @JoinColumn(name="FK",referencedColumnName="")
	 */ /*
		 * @OneToOne(cascade=CascadeType.ALL,mappedBy="salary") private Employee empId;
		 */

}
