package it.objectmethod.worldmapspringboot.restcontroller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import it.objectmethod.worldmapspringboot.domain.Nation;
import it.objectmethod.worldmapspringboot.repository.CountryRepository;

@RestController
public class NationRestController {

	// @Autowired
	// private INationDao iDaoNation;

	@Autowired
	private CountryRepository countryRepository;

	@GetMapping("/nationjdbc")
	public List<Nation> showNations(@PathParam("continent") String continent, HttpSession session) {
		List<Nation> countries = null;

		/*if (continent == null || continent.equals("")) {
			continent = (String) session.getAttribute("continent");
		} else {
			session.setAttribute("continent", continent);
		}*/

		countries = countryRepository.getCountryByContinentAsc(continent);
		// nations = iDaoNation.getAllContinentNations(continent);

		return countries;
	}

	/*
	 * @GetMapping("/viewNationForUpdateCity") public String getAllNations(ModelMap
	 * model,@PathParam("countryCode") String countryCode) {
	 * 
	 * List<Nation> nations = null; Nation nation = null;
	 * 
	 * System.out.println(countryCode);
	 * 
	 * nation=iDaoNation.reserchNationForCode(countryCode);
	 * nations=iDaoNation.getAllNationLessOneCountry(countryCode);
	 * 
	 * model.addAttribute("nameNation", nation.getName());
	 * model.addAttribute("result", nations);
	 * 
	 * return "insertModifyPageCity"; }
	 */

}
