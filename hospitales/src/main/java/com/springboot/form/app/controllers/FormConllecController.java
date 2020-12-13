package com.springboot.form.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class FormConllecController {

	@GetMapping("/formCollec")
	public String collec(Model model) {
		model.addAttribute("titulo", "Formulario ");
		return "formCollec";
	}
	
	@PostMapping("/formCollec")
	public String visualis(Model model,
			@RequestParam String nombreDirector,
			@RequestParam String tituloDirector,
			@RequestParam String profecionDirector,
			@RequestParam String emailDirector,
			@RequestParam Integer telefDirector,
			
			@RequestParam String nombreSubdirector,
			@RequestParam String tituloSubdirector,
			@RequestParam String profecionSubdirector,
			@RequestParam String emailSubdirector,
			@RequestParam Integer telefSubdirector,
			
			@RequestParam String nombreAdministrador,
			@RequestParam String tituloAdministrador,
			@RequestParam String profecionAdministrador,
			@RequestParam String emailAdministrador,
			@RequestParam Integer telefAdministrador,
			
			@RequestParam Integer casosNeg,
			@RequestParam Integer casosEstudio,
			@RequestParam Integer casosPositi,
			@RequestParam Integer Recuperados,
			@RequestParam Integer Defunciones,
			
			@RequestParam String nombreHos,
			@RequestParam String direccionHos,
			@RequestParam String municipioHos,
			@RequestParam Integer nMedicos,
			@RequestParam Integer nAmbulancias,
			@RequestParam Integer nCuartos,
			@RequestParam Integer nEnfermos,
			@RequestParam Integer nCamillas,
			@RequestParam Integer nLaboratorios,
			@RequestParam String servicioHos) {
		
		
		
		model.addAttribute("titulo", "Formulario");
		
		System.out.print(nombreSubdirector);
		return "redirect:/formCollec";
	}
	
}
