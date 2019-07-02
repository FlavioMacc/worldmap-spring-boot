package it.objectmethod.worldmapspringboot.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import it.objectmethod.worldmapspringboot.dao.ICityDao;
import it.objectmethod.worldmapspringboot.domain.City;

@RestController
public class CityController {

	@Autowired
	private ICityDao iCityDao;

	@GetMapping("/cityJdbc")
	public List<City> snowCitys(@PathParam("nation") String nation, @PathParam("order") String order,HttpSession session) {
		List<City> citys = null;
		
		if(nation == null)
			nation=(String)session.getAttribute("nation");
		else
			session.setAttribute("nation", nation);
		
		if (order == null || order.equals("Z-a")) {
			order = "ASC";

		} else {
			order = "DESC";
		}

		citys = iCityDao.getAllNationCitys(nation, order);

		return citys;
	}

	@GetMapping("/insertCity")
	public String insertCity(@PathParam("city") String city, @PathParam("nation") String nation) {
		iCityDao.insertCity(city, nation);
		return "forward:/cityJdbc";
	}

	@GetMapping("/deleteCity")
	public void deleteCity(@PathParam("idCity") String idCity) {
		iCityDao.deleteCity(Integer.parseInt(idCity));
		//return "forward:/cityJdbc";
	}

	@GetMapping("/updateCity")
	public void updateCity(@PathParam("city") String city, @PathParam("idCity") String idCity,
			@PathParam("nation") String nation) {
		iCityDao.modifyCity(city, nation, Integer.parseInt(idCity));
		//return "forward:/cityJdbc";
	}

	/*
	@GetMapping(value = { "insertCityPage", "updateCityPage" })
	public String insertModifyPage(ModelMap model, @PathParam("idCity") String idCity,@PathParam("nation") String nation) {
		String titlePage = null;
		String formAction = null;

		if (idCity.equals("")) {
			titlePage = "INSERIMENTO";
			formAction = "insertCity";

		} else {
			titlePage = "MODIFICA";
			formAction = "updateCity";
		}
		

		model.addAttribute("formAction", formAction);
		model.addAttribute("titlePage", titlePage);

		return "forward:/viewNationForUpdateCity?countryCode="+nation;
	}
	*/
}
