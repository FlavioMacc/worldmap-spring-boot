package it.objectmethod.worldmapspringboot.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import it.objectmethod.worldmapspringboot.dao.INationDao;

@RestController
public class ContinentRestController {

	@Autowired
	private INationDao iDaoNation;

	@GetMapping("continent")
	public List<String> showContinents() {
		List<String> continents = iDaoNation.getAllContinents();

		return continents;

	}

}
