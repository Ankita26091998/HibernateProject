package com.hibernate.mapping.onetoone;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Questions {
	@Id
	private long queId;
	private String queName;

	@OneToOne
	@JoinColumn(name = "ansId")
	private Answer answer;

	public Questions() {
		super();
	}

	public Questions(long queId, String queName, Answer answer) {
		super();
		this.queId = queId;
		this.queName = queName;
		this.answer = answer;
	}

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

	public long getQueId() {
		return queId;
	}

	public void setQueId(long queId) {
		this.queId = queId;
	}

	public String getQueName() {
		return queName;
	}

	public void setQueName(String queName) {
		this.queName = queName;
	}

}
