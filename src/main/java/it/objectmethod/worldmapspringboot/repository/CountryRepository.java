package it.objectmethod.worldmapspringboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.objectmethod.worldmapspringboot.domain.Nation;

@Repository
public interface CountryRepository extends JpaRepository<Nation, Long> {

	@Query(value="select n from Nation n where n.continent = ?1 order by n.name asc")
	public List<Nation> getCountryByContinentAsc(String continent);
	
}
