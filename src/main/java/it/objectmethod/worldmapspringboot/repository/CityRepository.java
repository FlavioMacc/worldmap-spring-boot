package it.objectmethod.worldmapspringboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.objectmethod.worldmapspringboot.domain.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

	@Query(value="select c from City c where c.countryCode = ?1 order by c.name asc")
	public List<City> getCitiesByCountryCodeAsc(String coutryCode);
	
	@Query(value="select c from City c where c.countryCode = ?1 order by c.name desc")
	public List<City> getCitiesByCountryCodeDesc(String coutryCode);
}
