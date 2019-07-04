package it.objectmethod.worldmapspringboot.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="country")
public class Nation {
	
	@Id
	private String code;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="Continent")
	private String continent;
	
	@Column(name="Population")
	private String popolation;
	
	//@JoinColumn(name="CountryCode")
	//@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	//private List<City> cities;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public String getPopolation() {
		return popolation;
	}

	public void setPopolation(String popolation) {
		this.popolation = popolation;
	}

	/*public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}*/

}
