package com.bolsadeideas.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;


import com.bolsadeideas.springboot.web.app.models.Usuario;

//CTRL+SHIFT+F para dar formato al texto o source format

//@RequestMapping("/app") para pasar a las rutas del controlador debo pasar primero por /app, yo le pongo el nombre que quiero

@Controller
@RequestMapping("/app")
public class IndexController {

	/* Nota Ctrl+Space para importar annotations */
	/* @RequestMapping(value="/index",method = RequestMethod.GET) */
	/* otra forma @GetMapping("/index") */
	/* otra forma @PostMapping) */
	/* Por defecto es get igual si no lo pongo */
	/* Esto le da la ruta, si quiero mas de una ruta {"/index", "/", "/home"} */

	@GetMapping("/holamundo")
	public String holaMundo() {

		/*
		 * retorna el nombre de la vista por lo que voy a tener que crear una plantilla
		 * que sea index.html, la guardo en resources/templates
		 */
		return "holamundo";
	}

	@GetMapping({ "/index", "/", "", "/home" })

//	Interfaz Model: para pasar datos del controlador a la vista	
//	Model es la más utilizada

	public String index(Model model) {
		model.addAttribute("titulo", "hola Spring Framework!");

		return "index";
	}

	/*
	 * implementación con ModelMap public String index(ModelMap model) {
	 * model.addAttribute("titulo", "hola Spring Framework!"); return "modelMap"; }
	 */

	/*
	 * Podemos usar Map directamente Map<String, Object> map en vez de Model model o
	 * ModelMap model map.put en vez de addAttribute
	 */

	/*
	 * Otra implementacion ModelAndView mv mv.addObject(.... etc) le podemos asignar
	 * el nombre de la vista a cargar return mv Public ModelAndView
	 * index(ModelAndView mv {ModelAndView mv) { mv.addObject("titulo",
	 * "hola spring"); mv.setViewName("index"); return mv;
	 */

	@RequestMapping("/perfil")
	public String perfil(Model model) {

		Usuario usuario = new Usuario();
		usuario.setNombre("Nicolas");
		usuario.setApellido("Pfleger");
		usuario.setEmail("nicolas.pfleger@gmail.com");

		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo",
				"Perfil del usuario: ".concat(usuario.getNombre().concat(" ").concat(usuario.getApellido())));

		// Si la vista esta en algun directorio dentro de templates pongo
		// directorio/vista
		return "perfil";
	}

	@RequestMapping("/listar")
	public String listar(Model model) {
		
				
		model.addAttribute("titulo", "Listado de usuarios");
		//model.addAttribute("usuarios", usuarios); No lo necesito si uso ModelAttribute

		// Si la vista esta en algun directorio dentro de templates pongo
		// directorio/vista
		return "listar";
	}
	
	
	//El model attribute hace que le pasa al Model el atributo usuario, para todos los metodos del controlador
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios() {
		
		
		/*
		 * Es lo mismo que esto
		 * 
		 * List<Usuario> usuarios = new ArrayList<>(); 
		 * usuarios.add(new Usuario("Nicolas", "Pfleger", "nicolas.pfleger@gmail.com")); 
		 * usuarios.add(new Usuario("Tamara", "Cardozo", "cardozotamara7@gmail.com")); 
		 * usuarios.add(new Usuario("Deborah", "Schwarz", "deborah.schwarz@gmail.com"));
		 */
		
		
		List<Usuario> usuarios = Arrays.asList(
				new Usuario("Nicolas", "Pfleger", "nicolas.pfleger@gmail.com"),
				new Usuario("Tamara", "Cardozo", "cardozotamara7@gmail.com"),
				new Usuario("Deborah", "Schwarz", "deborah.schwarz@gmail.com"),
				new Usuario("John", "Doe", "john.doe@gmail.com")
				);
		return usuarios;
	}

}
