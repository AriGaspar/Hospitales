package com.springboot.form.app.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
import org.springframework.boot.autoconfigure.gson.GsonProperties;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.form.app.models.Hospital;

@Controller
public class homeController {

	private String _termino;

	@RequestMapping("/home")
	public String home(Model model) {
		return "home";
	}

	@PostMapping({"/home","/search","/hospital{nombre}"})
	public String getTermino(String busqueda, Model model) {
		/* System.out.println("Lo que se busco es esto creo: "+busqueda); */
		// model.addAttribute("termino",busqueda);
		this._termino = busqueda;
		System.out.println("termino: " + this._termino);
		return "redirect:/search?busqueda=".concat(this._termino);
	}

	@ModelAttribute("termino")
	public String termino() {

		return _termino;
	}

	@GetMapping("/search")
	public String search(@RequestParam(value="busqueda",required=true) String busqueda, Model model) {
		Stream<Hospital> hospitales = hospitales().stream()
				.filter(h -> h.getNombre().toLowerCase().contains(busqueda.toLowerCase()));
		List<Hospital> nombres = new ArrayList<>();
		hospitales.forEach(h -> nombres.add(h));
		model.addAttribute("hospitales", nombres);
		model.addAttribute("busqueda", busqueda);

		return "search";
	}
	
	@GetMapping("/hospital")
	public String apartadoInfoHospital(@RequestParam(value="nombre",required=true) String nombre, Model model) {
		
		Stream<Hospital> hospitales = hospitales().stream()
				.filter(h -> h.getNombre().toLowerCase().equals(nombre.toLowerCase()));
		List<Hospital> hospital = new ArrayList<>();
		hospitales.forEach(h -> hospital.add(h));
		model.addAttribute("hospital", hospital);//
		return "apartado_hospital";
	}

	public List<Hospital> hospitales() {
		List<Hospital> hospitales = Arrays.asList(
				new Hospital(1, "Hospital Santa Maria", true, "Calle 42", "Pediatria-Caca-Caca2-Pedos2-Pedaturbia"),
				new Hospital(2, "Hospital Mendez", true, "Calle 542", "Pedosia-Caca-Caca2-Pedos2-Pedaturbia"),
				new Hospital(3, "Hospital Zaragoza", false, "Calle 412", "Muerteria-Caca-Caca2-Pedos2-Pedaturbia"),
				new Hospital(4, "Hospital CAKITO", true, "Calle 422", "Pediatria-Puerqueria-Caca2-Pedos2-Pedaturbia"),
				new Hospital(5, "Hospital Mamaaaaaaaaaaaa", false, "Calle 52",
						"Motoneria-Caca-Caca2-Pedos2-Pedaturbia"),
				new Hospital(5, "Hospital Perro Atropellado", true, "Calle 32",
						"Astigenesiologincatuquitia-Caca-Caca2-Pedos2-Pedaturbia"));
		return hospitales;
	}

}
