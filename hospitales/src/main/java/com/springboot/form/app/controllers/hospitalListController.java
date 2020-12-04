package com.springboot.form.app.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.springboot.form.app.models.Hospital;

@Controller
public class hospitalListController {

	private obtenerInfoDesdeBD servicio;
	
	@Autowired
	public hospitalListController(@Qualifier("informacionDesdeBD") obtenerInfoDesdeBD servicio) {
		this.servicio=servicio;
	}
	
	
	@GetMapping("/lista-info")
	public String mostrarDatosHospitales(Model model) {
		
		model.addAttribute("hospitales", servicio.getHospitalesActuales());

		return "lista_hospital";
	}

	

}
