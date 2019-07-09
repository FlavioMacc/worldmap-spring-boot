package it.objectmethod.worldmapspringboot.restcontroller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.objectmethod.worldmapspringboot.domain.City;
import it.objectmethod.worldmapspringboot.repository.CityRepository;

@RestController
public class CityRestController {

	// @Autowired
	// private ICityDao iCityDao;
	@Autowired
	private CityRepository cityRepository;

	@GetMapping("/cityJdbc")
	public List<City> showCities(@PathParam("nation") String nation, @PathParam("order") String order,
			HttpSession session) {
		List<City> cities = null;

		/*if (nation == null || nation.equals(""))
			nation = (String) session.getAttribute("nation");
		else
			session.setAttribute("nation", nation);*/

		if (order.equals("Z-a")) {
			cities = cityRepository.getCitiesByCountryCodeDesc(nation);

		} else {
			cities = cityRepository.getCitiesByCountryCodeAsc(nation);
		}

		return cities;
	}

	@DeleteMapping("/deleteCity")
	public void deleteCity(@PathParam("idCity") Long idCity) {
		System.out.println("-------------"+idCity);
		cityRepository.delete(idCity);
	}

	@GetMapping("/insertCity")
	public void insertCity(@RequestBody City city) {
		cityRepository.save(city);
	}

	@GetMapping("/updateCity")
	public void updateCity(@RequestBody City city, @PathParam("idCity") Long idCity) {

		City oldCity = cityRepository.getOne(idCity);
		oldCity.setName(city.getName());
		oldCity.setCountryCode(city.getCountryCode());
		cityRepository.save(oldCity);
	}

	/*
	 * @GetMapping("/cityJdbc") public List<City> showCitys(@PathParam("nation")
	 * String nation, @PathParam("order") String order,HttpSession session) {
	 * List<City> citys = null;
	 * 
	 * if(nation == null) nation=(String)session.getAttribute("nation"); else
	 * session.setAttribute("nation", nation);
	 * 
	 * if (order == null || order.equals("Z-a")) { order = "ASC";
	 * 
	 * } else { order = "DESC"; }
	 * 
	 * citys = iCityDao.getAllNationCitys(nation, order);
	 * 
	 * return citys; }
	 * 
	 * @GetMapping("/insertCity") public String insertCity(@PathParam("city") String
	 * city, @PathParam("nation") String nation) { iCityDao.insertCity(city,
	 * nation); return "forward:/cityJdbc"; }
	 * 
	 * @GetMapping("/deleteCity") public void deleteCity(@PathParam("idCity") String
	 * idCity) { iCityDao.deleteCity(Integer.parseInt(idCity)); //return
	 * "forward:/cityJdbc"; }
	 * 
	 * @GetMapping("/updateCity") public void updateCity(@PathParam("city") String
	 * city, @PathParam("idCity") String idCity,
	 * 
	 * @PathParam("nation") String nation) { iCityDao.modifyCity(city, nation,
	 * Integer.parseInt(idCity)); //return "forward:/cityJdbc"; }
	 * 
	 * /*
	 * 
	 * @GetMapping(value = { "insertCityPage", "updateCityPage" }) public String
	 * insertModifyPage(ModelMap model, @PathParam("idCity") String
	 * idCity,@PathParam("nation") String nation) { String titlePage = null; String
	 * formAction = null;
	 * 
	 * if (idCity.equals("")) { titlePage = "INSERIMENTO"; formAction =
	 * "insertCity";
	 * 
	 * } else { titlePage = "MODIFICA"; formAction = "updateCity"; }
	 * 
	 * 
	 * model.addAttribute("formAction", formAction); model.addAttribute("titlePage",
	 * titlePage);
	 * 
	 * return "forward:/viewNationForUpdateCity?countryCode="+nation; }
	 */
}
