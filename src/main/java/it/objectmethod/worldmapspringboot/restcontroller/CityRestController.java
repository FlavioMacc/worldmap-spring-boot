package it.objectmethod.worldmapspringboot.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.objectmethod.worldmapspringboot.domain.City;
import it.objectmethod.worldmapspringboot.repository.CityRepository;

@RestController
public class CityRestController {

	@Autowired
	private CityRepository cityRepository;

	@GetMapping("/cityJdbc")
	public List<City> showCities(@RequestParam("nation") String nation, @RequestParam("order") String order) {
		List<City> cities = null;

		if (order.equals("Z-a")) {
			cities = cityRepository.getCitiesByCountryCodeDesc(nation);

		} else {
			cities = cityRepository.getCitiesByCountryCodeAsc(nation);
		}

		return cities;
	}

	@DeleteMapping("/city/{idCity}/delete")
	public void deleteCity(@PathVariable("idCity") Long idCity) {
		cityRepository.delete(idCity);
	}

	@PostMapping("/city/insert")
	public void insertCity(@RequestBody City city) {
		cityRepository.save(city);
	}

	@PutMapping("/city/update")
	public void updateCity(@RequestBody City city/*, @RequestParam("idCity") Long idCity*/) {
		
		Long idCity= city.getIdCity();
		
		City oldCity = cityRepository.getOne(idCity);
		oldCity.setName(city.getName());
		oldCity.setCountryCode(city.getCountryCode());
		cityRepository.save(oldCity);
	}
}
