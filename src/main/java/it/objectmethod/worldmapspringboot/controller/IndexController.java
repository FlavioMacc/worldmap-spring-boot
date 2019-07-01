package it.objectmethod.worldmapspringboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping("/")
	   public String continents() { 
	        return "index";
	    }
}
