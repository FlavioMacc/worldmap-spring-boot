package it.objectmethod.worldmapspringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import it.objectmethod.worldmapspringboot.dao.INationDao;

@RestController
public class ContinentController {
	
	@Autowired
	private INationDao iDaoNation;
	
	@PostMapping(value = { "/", "continent" })
	public List<String> snowContinents() {
		List<String> continents = iDaoNation.getAllContinents();

		return continents;
	}
}
