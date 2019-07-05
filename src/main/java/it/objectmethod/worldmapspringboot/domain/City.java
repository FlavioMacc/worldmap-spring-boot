package it.objectmethod.worldmapspringboot.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "city")
public class City {

	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private long ID;

	@Column(name = "Name")
	private String name;

	@Column(name = "CountryCode")
	private String countryCode;

	// @JsonIgnore
	// @ManyToOne
	// private Nation nation;

	public long getIdCity() {
		return ID;
	}

	public void setIdCity(long ID) {
		this.ID = ID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/*
	 * public Nation getNation() { return nation; }
	 * 
	 * public void setNation(Nation nation) { this.nation = nation; }
	 */

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

}
