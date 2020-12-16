package com.springboot.form.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@RequestMapping(value = "/lista-hospitales/{id}", method = RequestMethod.DELETE)
	public String borrarDatosHospitales(@PathVariable Integer id) {

		System.out.println("Esto a eliminar: "+id);
		
		return "redirect:/lista-hospitales";
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

	

	
}
