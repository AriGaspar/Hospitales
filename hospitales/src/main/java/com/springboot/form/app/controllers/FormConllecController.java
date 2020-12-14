package com.springboot.form.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.form.app.models.Covid;
import com.springboot.form.app.models.Hospital;
import com.springboot.form.app.models.Persona;



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
	@Component
	public class FormConllecController implements obtenerInfoDesdeBD{
		private List<Hospital> from=getHospitalesDesdeBD();
		public List<Hospital> from=new ArrayList<Hospital>();
		
		@Override
		public List<Hospital> getHospitalesDesdeBD() {
			new Hospital(1, nombreHos, casosEstudio,municipioHos,telefDirector,nMedicos,nAmbulancias,nCuartos,nEnfermos,nCamillas,nLaboratorios, servicioHos, 
					new Persona(1,nombreDirector,tituloDirector,profecionDirector,emailDirector,telefDirector),
					new Persona(23,nombreSubdirector,tituloSubdirector,profecionSubdirector,emailSubdirector,telefSubdirector),
					new Persona(14,nombreAdministrador,tituloAdministrador,profecionAdministrador,emailAdministrador,telefAdministrador),
					new Covid(casosNeg,casosEstudio,casosPositi,Recuperados,Defunciones))
			);
		}
		
	}
	
}
