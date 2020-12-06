package com.springboot.form.app.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.form.app.models.Hospital;
import com.springboot.form.app.models.Persona;

@Controller
public class editController {

	private obtenerInfoDesdeBD servicio;
	private List<Hospital> _hospitales;//Este es el hospital que se seleccione en los resultados
	private List<Hospital> _hospital = new ArrayList<>();//Este es el hospital que se seleccione en los resultados
	
	
	@Autowired
	public editController(@Qualifier("informacionDesdeBD") obtenerInfoDesdeBD servicio) {
		this.servicio=servicio;
		this._hospitales=servicio.getHospitalesActuales();
	}
	
	@PostMapping("/hospital")
	public String actualizarDatosHospitales(Hospital hospital, Model model) {
		List<Hospital> hospitalTemp = new ArrayList<>();
		
		hospital.setId(servicio.getHospitalActual().get(0).getId());
		hospitalTemp.add(hospital);
		
		servicio.setHospital(hospitalTemp);//Establece el hospital modificado dentro de la lista hospitales

		return "redirect:/lista-info";//Actualiza la pagina de todos los hospitales
	}
	@PostMapping("/personal")
	public String actualizarDatosPersonal(Persona persona, Model model) {
		System.out.println("nose: "+persona.get_nombre());
		List<Persona> personaTemp = new ArrayList<>();
//		persona.set_codigo(servicio.getHospitalActual().get(0).get_director());
//		personaTemp.add(persona);
		
		return "redirect:/lista-personal";//Actualiza la pagina de todos los hospitales
	}

	@GetMapping("/personal")
	public String editarPersona(@RequestParam(value = "nombre", required = true) String nombre, Model model) {
		List<Persona> personaTemp = new ArrayList<>();
		Stream<Hospital> hospitales = this.servicio.getHospitalesActuales().stream()
				.filter(h -> h.get_director().get_nombre().toLowerCase().equals(nombre.toLowerCase()) ||
							 h.get_subdirector().get_nombre().toLowerCase().equals(nombre.toLowerCase()) ||
							 h.get_administrador().get_nombre().toLowerCase().equals(nombre.toLowerCase()));
		
		hospitales.forEach(h -> {
			if(h.get_director().get_nombre().equals(nombre)) {
				personaTemp.add(h.get_director());
			}else if(h.get_subdirector().get_nombre().equals(nombre)) {
				personaTemp.add(h.get_subdirector());
			}else if(h.get_administrador().get_nombre().equals(nombre)) {
				personaTemp.add(h.get_administrador());
			}
		});
		
		model.addAttribute("persona", personaTemp.get(0));//
		return "editar-personal";
	}
	
	
	@GetMapping("/hospital")
	public String editarHospital(@RequestParam(value = "nombre", required = true) String nombre, Model model) {
		servicio.getHospitalActual().clear();
		List<Hospital> hospitalTemp = new ArrayList<>();
		Stream<Hospital> hospitales = this.servicio.getHospitalesActuales().stream()
				.filter(h -> h.getNombre().toLowerCase().equals(nombre.toLowerCase()));
		hospitales.forEach(h -> hospitalTemp.add(h));
		servicio.setHospitalActual(hospitalTemp);
		model.addAttribute("hospital", hospitalTemp);//
		return "editar-hospital";
	}

}
