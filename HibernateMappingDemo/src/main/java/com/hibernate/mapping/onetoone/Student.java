package com.hibernate.mapping.onetoone;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Student {
	@Id
	private long studId;
	private String studName;

	@OneToOne
	@JoinColumn(name = "trainerId")
	private Trainer trainer;

	public Student() {
		super();
	}

	public Student(long studId, String studName, Trainer trainer) {
		super();
		this.studId = studId;
		this.studName = studName;
		this.trainer = trainer;
	}

	public long getStudId() {
		return studId;
	}

	public void setStudId(long studId) {
		this.studId = studId;
	}

	public String getStudName() {
		return studName;
	}

	public void setStudName(String studName) {
		this.studName = studName;
	}

	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

}
