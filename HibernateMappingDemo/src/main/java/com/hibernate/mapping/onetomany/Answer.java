package com.hibernate.mapping.onetomany;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Answer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long ansId;
	private String ansName;

	@ManyToOne(cascade = CascadeType.ALL)
	private Questions question;

	public Answer(String ansName) {
		super();
		this.ansName = ansName;
	}

	public Questions getQuestions() {
		return question;
	}

	public void setQuestions(Questions questions) {
		this.question = questions;
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
