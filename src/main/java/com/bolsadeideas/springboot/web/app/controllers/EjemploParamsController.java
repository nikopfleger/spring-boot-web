package com.bolsadeideas.springboot.web.app.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class EjemploParamsController {

	@GetMapping("/")
	public String index() {
		return "params/index";
	}

	// puedo usar @RequestParam(name="texto") si no lo pongo toma el nombre de la
	// variable
	// Si quiero que el parametro sea opcional le agrego required=false, por defecto
	// es true
	// , o le puedo poner un defaultValue, porngo todo para mostrar
	@GetMapping("/string")
	public String param(@RequestParam(name = "texto", required = false, defaultValue = "Vacio") String texto,
			Model model) {
		model.addAttribute("resultado", "El texto enviado es: " + texto);
		return "params/ver";
	}

	@GetMapping("/mix-params")
	public String param(@RequestParam String saludo, @RequestParam Integer numero, Model model) {
		model.addAttribute("resultado", "El saludo enviado es: '" + saludo + "' y el numero es '" + numero + "'");
		return "params/ver";
	}

	// Con anotaciones es mas elegante y moderno y menos codigo. Esta es la forma
	// clasica (como usaba en PHP), ademas tengo que hacer mas codigo.
	@GetMapping("/mix-params-request")
	public String param(HttpServletRequest request, Model model) {
		String saludo = request.getParameter("saludo");
		Integer numero = null;
		try {
			numero = Integer.parseInt(request.getParameter("numero"));
		} catch (NumberFormatException e) {
			numero = 0;
		}

		model.addAttribute("resultado", "El saludo enviado es: '" + saludo + "' y el numero es '" + numero + "'");
		return "params/ver";
	}

}
