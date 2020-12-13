package com.springboot.form.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.form.app.models.CasosCovid;
import com.springboot.form.app.models.Directivo;


@Controller
public class FormDirecControll {
	
	@GetMapping("/formDirec")
	public String form(Model model) {
		model.addAttribute("titulo", "Formulario Directivos");
		return "form_directiva";
	}
	
	@PostMapping("/formDirec")
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
		directivo.setTituloSubdirector(telefAdministrador);
		
		directivo.setNombreAdministrador(nombreAdministrador);
		directivo.setTituloAdministrador(tituloAdministrador);
		directivo.setProfecionAdministrador(profecionAdministrador);
		directivo.setEmailAdministrador(emailAdministrador);
		directivo.setTelefAdministrador(telefAdministrador);
		
		model.addAttribute("titulo", "Formulario");
		model.addAttribute("directivo", directivo);
		
		return "result";
	}
	
	@GetMapping("/formCovid")
	public String formcov(Model model,
			@RequestParam String casosNeg,
			@RequestParam String casosEstudio,
			@RequestParam String casosPositi,
			@RequestParam String Recuperados,
			@RequestParam String Defunciones){
		
		CasosCovid casos=new CasosCovid();
		
		casos.setCasosNeg(casosNeg);
		casos.setCasosEstudio(casosEstudio);
		casos.setCasosPositi(casosPositi);
		casos.setRecuperados(Recuperados);
		casos.setDefunciones(Defunciones);
		
		model.addAttribute("titulocov", "Formulario Covid-19");
		model.addAttribute("casos", casos);
		return ("formCovid");
	}
	
	@PostMapping("/formCovid")
	public String visu(Model model) {
		return"visuaCovid";
	}

}
