package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home() {
		//si quiero redirigir a google https://www.google.com
		//no puedo hacer forward a rutas externas
		//con redirect se pierde la ruta y los parametros
		//forward:/app/index no hace recarga, los parametros del request no se pierden
		return "forward:/app/index";
	}
	
}
