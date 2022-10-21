package com.namequery;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({ @NamedQuery(name = "findLearnerbyId", query = "from Lerner l where l.id =:Id1"),
		@NamedQuery(name = "findLearnerbyName", query = "from Lerner where lernerName like 'P%' "),
		@NamedQuery(name = "findLearnerbyIdDesc", query = "from Lerner order by lernerId desc\r\n "),
		@NamedQuery(name = "findCitybyName", query = "from Lerner where lernerName=:LName ") })
@Entity
public class Lerner {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int lernerId;
	private String lernerName;
	private String lernerCity;

	public Lerner() {
		super();
	}

	public Lerner(String lernerName, String lernerCity) {
		super();
		this.lernerName = lernerName;
		this.lernerCity = lernerCity;
	}

	public long getLernerId() {
		return lernerId;
	}

	public void setLernerId(int lernerId) {
		this.lernerId = lernerId;
	}

	public String getLernerName() {
		return lernerName;
	}

	public void setLernerName(String lernerName) {
		this.lernerName = lernerName;
	}

	public String getLernerCity() {
		return lernerCity;
	}

	public void setLernerCity(String lernerCity) {
		this.lernerCity = lernerCity;
	}

}
