package com.hibernate.mapping.onetoone;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Answer {
	@Id
	private long ansId;
	private String ansName;

	@OneToOne(mappedBy = "answer")
	private Questions questions;

	public Questions getQuestions() {
		return questions;
	}

	public void setQuestions(Questions questions) {
		this.questions = questions;
	}

	public long getAnsId() {
		return ansId;
	}

	public void setAnsId(long ansId) {
		this.ansId = ansId;
	}

	public String getAnsName() {
		return ansName;
	}

	public void setAnsName(String ansName) {
		this.ansName = ansName;
	}
}
