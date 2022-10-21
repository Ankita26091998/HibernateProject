package com.criteria.query;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
//@Embeddable
//@Access(value = AccessType.PROPERTY)
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int eid;

	private String eName;
	private String ecity;
	private int esalary;
	private String edesignation;

	public Employee() {
		super();
	}

	public Employee(String eName, String ecity, int esalary, String edesignation) {
		super();
		this.eName = eName;
		this.ecity = ecity;
		this.esalary = esalary;
		this.edesignation = edesignation;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public String getEcity() {
		return ecity;
	}

	public void setEcity(String ecity) {
		this.ecity = ecity;
	}

	public int getEsalary() {
		return esalary;
	}

	public void setEsalary(int esalary) {
		this.esalary = esalary;
	}

	public String getEdesignation() {
		return edesignation;
	}

	public void setEdesignation(String edesignation) {
		this.edesignation = edesignation;
	}

}
