package com.springboot.form.app.controllers;

import java.util.ArrayList;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

//import com.bolsadeideas.springboot.form.app.models.domain.Usuario;
import com.springboot.form.app.models.Covid;
import com.springboot.form.app.models.Hospital;
import com.springboot.form.app.models.Persona;

@Controller
public class editController {
	
	
	private obtenerInfoDesdeBD servicio;
	@Autowired
	public editController(@Qualifier("informacionDesdeBD") obtenerInfoDesdeBD servicio) {
		this.servicio=servicio;
	}
	
	@PostMapping("/hospital")
	public String actualizarDatosHospitales(Hospital hospital , Model model) {
		servicio.setHospital(hospital);//Establece el hospital modificado dentro de la lista hospitales
		
		return "redirect:/lista-hospitales";//Actualiza la pagina de todos los hospitales
	}
	@PostMapping("/personal")
	public String actualizarDatosPersonal(@ModelAttribute Persona persona , Model model) {
		servicio.setPersonal(persona);
		return "redirect:/lista-personal";//Actualiza la pagina de todos los hospitales
	}

	@PostMapping("/covid")
	public String actualizarDatosCovid(@ModelAttribute Covid covid , Model model) {
		
		servicio.setCovid(covid);
		
		return "redirect:/lista-covid";//Actualiza la pagina de todos los hospitales
	}
	
	@GetMapping("/covid")
	public String editarCovid(@RequestParam(value = "id", required = true) Integer id, Model model) {
		
		model.addAttribute("covid", getCovidActual(id));//
		
		return "editar-covid";
	}
	
	@GetMapping("/personal")
	public String editarPersona(@RequestParam(value = "id", required = true) int id, Model model) {
		
		model.addAttribute("persona", getPersonaActual(id));//
		return "editar-personal";
	}
	
	
	@GetMapping("/hospital")
	public String editarHospital(@RequestParam(value = "nombre", required = true) String nombre, Model model) {
		
		model.addAttribute("hospital", getHospitalActual(nombre));//
		
		return "editar-hospital";
	}
	
	private Persona getPersonaActual(Integer id){

		Persona personaTemp = new Persona();
		
		List<Persona> personasDesdeBD=servicio.getPersonal();
		for (Persona persona : personasDesdeBD) {
			if(id == persona.getCodigo()) {
				personaTemp=persona;
				break;
			}
		}
		return personaTemp;
	}
	
	private Covid getCovidActual(Integer id){

		Covid covidTemp = new Covid();
		
		List<Covid> covidDesdeDB=servicio.getRegistrosCovid();
		for (Covid c : covidDesdeDB) {
			if(id == c.getId()) {
				covidTemp=c;
				break;
			}
		}
		return covidTemp;
	}
	private Hospital getHospitalActual(String _name){

		Hospital hospTemp = new Hospital();
		
		List<Hospital> hospitalDesdeDB=servicio.getG();
		for (Hospital h : hospitalDesdeDB) {
			try {
				if(h.getNombre().equals(_name)) {
					hospTemp=h;
					break;
				}
			} catch (Exception e) {
				System.out.println(e);
			}
			
		}
		return hospTemp;
	}
	
	

}
