package it.objectmethod.worldmapspringboot.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.objectmethod.worldmapspringboot.domain.Nation;
import it.objectmethod.worldmapspringboot.repository.CountryRepository;

@RestController
public class NationRestController {

	@Autowired
	private CountryRepository countryRepository;

	@GetMapping("/nationjdbc")
	public List<Nation> showNations(@RequestParam("continent") String continent) {
		List<Nation> countries = null;

		countries = countryRepository.getCountryByContinentAsc(continent);

		return countries;
	}
	
	@GetMapping("/getAllCountries")
	public List<Nation> getAllCoutries(){
		List<Nation> countries = null;
		countries=countryRepository.findAll();
		return countries;
	}
}
