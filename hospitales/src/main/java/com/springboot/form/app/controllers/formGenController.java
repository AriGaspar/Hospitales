package com.springboot.form.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.form.app.models.General;

@Controller
public class formGenController {

	@GetMapping("/formgen")
	public String form(Model model) {
		model.addAttribute("titulo", "Formulario de Datos Generales");
		return "formGeneral";
	}

	@PostMapping("/formgen")
	public String cargar(Model model, @RequestParam String nombreHos, @RequestParam String direccionHos,
			@RequestParam String municipioHos, @RequestParam int nMedicos, @RequestParam int nAmbulancias,
			@RequestParam int nCuartos, @RequestParam int nEnfermos, @RequestParam int nCamillas,
			@RequestParam int nLaboratorios, @RequestParam String servicioHos) {
		General general = new General();

		general.setNombreHos(nombreHos);
		general.setDireccionHos(direccionHos);
		general.setMunicipioHos(municipioHos);
		general.setnMedicos(nMedicos);
		general.setnAmbulancias(nAmbulancias);
		general.setnCuartos(nCuartos);
		general.setnEnfermos(nEnfermos);
		general.setnCamillas(nCamillas);
		general.setnLaboratorios(nLaboratorios);
		general.setServicioHos(servicioHos);

		model.addAttribute("titulo", "Resultado General Hospital");
		model.addAttribute("general", general);

		return "resHos";
	}
}
