package com.hibernate.jpa.crud.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int eid;
	@Column(unique = true, length = 15, nullable = false)
	private String ename;
	private int esalary;
	private String ecity;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String ename, int esalary, String ecity) {
		super();
		this.ename = ename;
		this.esalary = esalary;
		this.ecity = ecity;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public int getEsalary() {
		return esalary;
	}

	public void setEsalary(int esalary) {
		this.esalary = esalary;
	}

	public String getEcity() {
		return ecity;
	}

	public void setEcity(String ecity) {
		this.ecity = ecity;
	}

}
