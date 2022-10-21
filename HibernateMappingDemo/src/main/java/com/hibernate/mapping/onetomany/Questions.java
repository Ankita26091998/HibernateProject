package com.hibernate.mapping.onetomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Question")
public class Questions {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long queId;
	@Column(name = "questionName", length = 20, unique = true, nullable = false)
	private String queName;

	@OneToMany(mappedBy = "question")

	private List<Answer> ansList = new ArrayList<Answer>();

	public Questions() {
		super();
	}

	public List<Answer> getAnsList() {
		return ansList;
	}

	public void setAnsList(List<Answer> ansList) {
		this.ansList = ansList;
	}

	public Questions(long queId, String queName) {
		super();
		this.queId = queId;
		this.queName = queName;
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
