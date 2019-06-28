package it.objectmethod.worldmapspringboot.controller;

import java.util.List;

//import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import it.objectmethod.worldmapspringboot.dao.INationDao;
import it.objectmethod.worldmapspringboot.domain.Nation;

@RestController
public class NationController {

	@Autowired
	private INationDao iDaoNation;

	@PostMapping("/nationjdbc")
	public List<Nation> snowNations(@PathParam("continent") String continent) {
		List<Nation> nations = null;
		
		//if(continent == null)
			//continent=(String)session.getAttribute("continent");
		//else
			//session.setAttribute("continent", continent);
		
		nations = iDaoNation.getAllContinentNations(continent);
		
		return nations;
	}
	
	/*@GetMapping("/viewNationForUpdateCity")
	public String getAllNations(ModelMap model,@PathParam("countryCode") String countryCode) {
		
		List<Nation> nations = null;
		Nation nation = null;
		
		System.out.println(countryCode);
		
		nation=iDaoNation.reserchNationForCode(countryCode);
		nations=iDaoNation.getAllNationLessOneCountry(countryCode);
		
		model.addAttribute("nameNation", nation.getName());
		model.addAttribute("result", nations);
		
		return "insertModifyPageCity";
	}*/

}
