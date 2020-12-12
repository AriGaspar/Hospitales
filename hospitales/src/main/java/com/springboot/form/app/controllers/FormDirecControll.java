package com.springboot.form.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.form.app.models.Directivo;


@Controller
public class FormDirecControll {
	
	@GetMapping("/form")
	public String form(Model model) {
		model.addAttribute("titulo", "Formulario");
		return "form_directiva";
	}
	
	@PostMapping("/form")
	public String procesar(Model model,

			@RequestParam String nombreDirector,
			@RequestParam String tituloDirector,
			@RequestParam String profecionDirector,
		    @RequestParam String emailDirector,
			@RequestParam String telefDirector,
			
			@RequestParam String nombreSubdirector,
			@RequestParam String tituloSubdirector,
			@RequestParam String profecionSubdirector,
			@RequestParam String emailSubdirector,
			@RequestParam String telefSubdirector,
			
			@RequestParam String nombreAdministrador,
			@RequestParam String tituloAdministrador,
			@RequestParam String profecionAdministrador,
			@RequestParam String emailAdministrador,
			@RequestParam String telefAdministrador) {
		
		Directivo directivo=new Directivo();
		
		directivo.setNombreDirector(nombreDirector);
		directivo.setTituloDirector(tituloDirector);
		directivo.setProfecionDirector(profecionDirector);
		directivo.setEmailDirector(emailDirector);
		directivo.setTelefDirector(telefDirector);
		
		directivo.setNombreSubdirector(nombreSubdirector);
		directivo.setTituloSubdirector(tituloSubdirector);
		directivo.setProfecionSubdirector(profecionSubdirector);
		directivo.setEmailSubdirector(emailSubdirector);
		directivo.setTituloSubdirector(tituloSubdirector);
		
		directivo.setNombreAdministrador(nombreAdministrador);
		directivo.setTituloAdministrador(tituloAdministrador);
		directivo.setProfecionAdministrador(profecionAdministrador);
		directivo.setEmailAdministrador(emailAdministrador);
		directivo.setTelefAdministrador(telefAdministrador);
		
		model.addAttribute("titulo", "Formulario");
		model.addAttribute("directivo", directivo);
		
		return "result";
	}

}
