package com.springboot.form.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.springboot.form.app.models.Covid;
import com.springboot.form.app.models.Hospital;
import com.springboot.form.app.models.Persona;

@Controller
public class hospitalListController {

	private obtenerInfoDesdeBD servicio;
	
	@Autowired
	public hospitalListController(@Qualifier("informacionDesdeBD") obtenerInfoDesdeBD servicio) {
		this.servicio=servicio;
	}
	//Pedos
	@GetMapping("/lista-hospitales")
	public String mostrarDatosHospitales(Model model) {
		
		model.addAttribute("hospitales", servicio.getHospitalesActuales());
		
		return "lista_hospital";
	}
	@GetMapping("/lista-personal")
	public String mostrarDatosPersonal(Model model) {

		model.addAttribute("personal", this.getPersonal(servicio.getHospitalesActuales()));
		
		return "lista-persona";
	}
	@GetMapping("/lista-covid")
	public String mostrarDatosCovid(Model model) {
		
		model.addAttribute("covid", this.getCovid(servicio.getHospitalesActuales()));
		
		return "lista_covid";
	}
	
	//Obtiene todo los registros del personal de todos los hospitales
	private List<Persona> getPersonal(List<Hospital> h) {
		List<Persona> p = new ArrayList<Persona>();
		
		for ( int i = 0 ; i < h.size() ; i++ ) {
			p.add( h.get(i).get_director() );//Director
			p.add( h.get(i).get_subdirector() );//Subdirector
			p.add( h.get(i).get_administrador() );//Administrador
		}
		
		
		return p;
	}
	
	//Obtiene todo los registros de COVID de todos los hospitales
	private List<Covid> getCovid (List<Hospital> h) {
		List<Covid> c = new ArrayList<Covid>();
		
		for ( int i = 0 ; i < h.size() ; i++ ) {
			c.add( h.get(i).get_covid() );//Covid
		}
		
		return c;
	}
	

	

}
