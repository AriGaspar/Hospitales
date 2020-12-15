package com.springboot.form.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.springboot.form.app.dao.IAdministradorRepo;
import com.springboot.form.app.dao.IDirectorRepo;
import com.springboot.form.app.dao.IHospital2Repo;
import com.springboot.form.app.dao.IPersona2Repo;
import com.springboot.form.app.dao.ISubdirectorRepo2;
import com.springboot.form.app.models.Administrador;
import com.springboot.form.app.models.Covid;
import com.springboot.form.app.models.Director;
import com.springboot.form.app.models.Hospital;
import com.springboot.form.app.models.Hospital2;
import com.springboot.form.app.models.Persona;
import com.springboot.form.app.models.Persona2;
import com.springboot.form.app.models.Subdirector;

@Controller
public class hospitalListController {
	private obtenerInfoDesdeBD servicio;

	@Autowired
	public hospitalListController(@Qualifier("informacionDesdeBD") obtenerInfoDesdeBD servicio) {
		this.servicio = servicio;
	
	}
	
	@GetMapping("/lista-hospitales")
	public String mostrarDatosHospitales(Model model) {

		model.addAttribute("hospitales", servicio.getHospitalesDesdeBD());
		
		return "lista_hospital";
	}

	@GetMapping("/lista-personal")
	public String mostrarDatosPersonal(Model model) {

		model.addAttribute("personal", servicio.getPersonal());

		return "lista-persona";
	}

	@GetMapping("/lista-covid")
	public String mostrarDatosCovid(Model model) {

		model.addAttribute("covid", servicio.getRegistrosCovid());

		return "lista_covid";
	}

	// Obtiene todo los registros del personal de todos los hospitales
	private List<Persona> getPersonal(List<Hospital> h) {
		List<Persona> p = new ArrayList<Persona>();

		for (int i = 0; i < h.size(); i++) {
			p.add(h.get(i).get_director());// Director
			p.add(h.get(i).get_subdirector());// Subdirector
			p.add(h.get(i).get_administrador());// Administrador
		}

		return p;
	}

	// Obtiene todo los registros de COVID de todos los hospitales
	private List<Covid> getCovid(List<Hospital> h) {
		List<Covid> c = new ArrayList<Covid>();

		for (int i = 0; i < h.size(); i++) {
			c.add(h.get(i).get_covid());// Covid
		}

		return c;
	}


	
}
