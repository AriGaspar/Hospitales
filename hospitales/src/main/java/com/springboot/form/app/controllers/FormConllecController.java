package com.springboot.form.app.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.form.app.models.ADMINISTRADORES;
import com.springboot.form.app.models.Covid2;
import com.springboot.form.app.models.DIRECTORES;
import com.springboot.form.app.models.HOSPITALS;
import com.springboot.form.app.models.Hospital;
import com.springboot.form.app.models.Persona;
import com.springboot.form.app.models.SUBDIRECTORES;



@Controller
public class FormConllecController {

	private obtenerInfoDesdeBD servicio;
	@Autowired
	public FormConllecController(@Qualifier("informacionDesdeBD") obtenerInfoDesdeBD servicio) {
		this.servicio=servicio;
	}
	
	@GetMapping("/insertar-hospital")
	public String collec(Hospital hospital) {
		System.out.println("id   "+ generateUniqueId());
		return "formCollec";
	}
	
	@PostMapping("/insertar-hospital")
	public String visualis(@RequestParam String nombreDirector,
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
			@RequestParam String telefAdministrador,
			
			@RequestParam Integer casosNeg,
			@RequestParam Integer casosEstudio,
			@RequestParam Integer casosPositi,
			@RequestParam Integer Recuperados,
			@RequestParam Integer Defunciones,
			
			@RequestParam String nombreHos,
			@RequestParam String direccionHos,
			@RequestParam String municipioHos,
			@RequestParam String telefonoH,
			@RequestParam Integer nMedicos,
			@RequestParam Integer nAmbulancias,
			@RequestParam Integer nCuartos,
			@RequestParam Integer nEnfermos,
			@RequestParam Integer nCamillas,
			@RequestParam Integer nLaboratorios,
			@RequestParam String servicioHos) {
		
		
		HOSPITALS hos=new HOSPITALS(generateUniqueId(), nombreHos, direccionHos,municipioHos,telefonoH,nMedicos,nEnfermos,nAmbulancias,nCamillas,nCuartos,nLaboratorios, servicioHos, 
				new DIRECTORES(generateUniqueId(), new Persona(generateUniqueId(),nombreDirector,tituloDirector,profecionDirector,emailDirector,telefDirector.toString())),
				new SUBDIRECTORES(generateUniqueId(), new Persona(generateUniqueId(),nombreSubdirector,tituloSubdirector,profecionSubdirector,emailSubdirector,telefSubdirector)),
				new ADMINISTRADORES(generateUniqueId(), new Persona(generateUniqueId(),nombreAdministrador,tituloAdministrador,profecionAdministrador,emailAdministrador,telefAdministrador)),
				new Covid2(generateUniqueId(),casosNeg,casosEstudio,casosPositi,Recuperados,Defunciones));
		servicio.setNewHospital(hos);
		
		return "redirect:/formCollec";
	}
	public int generateUniqueId() {      
        UUID idOne = UUID.randomUUID();
        String str=""+idOne;        
        int uid=str.hashCode();
        String filterStr=""+uid;
        str=filterStr.replaceAll("-", "");
        return Integer.parseInt(str.substring(0, 3));
    }
	
}
