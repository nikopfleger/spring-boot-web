package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class EjemploParamsController {

	//puedo usar @RequestParam(name="texto")  si no lo pongo toma el nombre de la variable
	//Si quiero que el parametro sea opcional le agrego required=false, por defecto es true
	//, o le puedo poner un defaultValue, porngo todo para mostrar
	@GetMapping("/string")
	public String param(@RequestParam(name="texto",required=false,defaultValue="Vacio") String texto, Model model) {
		model.addAttribute("resultado", "El texto enviado es: " + texto);
		return "params/ver";
	}
	
	@GetMapping("/")
	public String index() {
		return "params/index";
	}
}
