package com.hibernate.mapping.onetoone;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Trainer {
	@Id
	private long trainerId;
	private String trainerName;

	@OneToOne(mappedBy = "trainer")
	private Student student;

	public Trainer() {
		super();
	}

	public long getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(long trainerId) {
		this.trainerId = trainerId;
	}

	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Trainer(long trainerId, String trainerName, Student student) {
		super();
		this.trainerId = trainerId;
		this.trainerName = trainerName;
		this.student = student;
	}

}
