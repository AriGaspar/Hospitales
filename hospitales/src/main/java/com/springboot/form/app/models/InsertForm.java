package com.springboot.form.app.models;

public class InsertForm {

	private String nombreDirector;
	private String tituloDirector;
	private String profecionDirector;
	private String emailDirector;
	private Integer telefDirector;

	private String nombreSubdirector;
	private String tituloSubdirector;
	private String profecionSubdirector;
	private String emailSubdirector;
	private Integer telefSubdirector;

	private String nombreAdministrador;
	private String tituloAdministrador;
	private String profecionAdministrador;
	private String emailAdministrador;
	private Integer telefAdministrador;

	private Integer casosNeg;
	private Integer casosEstudio;
	private Integer casosPositi;
	private Integer Recuperados;
	private Integer Defunciones;

	private String nombreHos;
	private String direccionHos;
	private String municipioHos;
	private Integer nMedicos;
	private Integer nAmbulancias;
	private Integer nCuartos;
	private Integer nEnfermos;
	private Integer nCamillas;
	private Integer nLaboratorios;
	private String servicioHos;

	public InsertForm() {
	}

	public InsertForm(
		   String nombreDirector, 
		   String tituloDirector, 
		   String profecionDirector,
		   String emailDirector,
		   Integer telefDirector,
		   
		   String nombreSubdirector, 
		   String tituloSubdirector,
		   String profecionSubdirector,
		   String emailSubdirector, 
		   Integer telefSubdirector,
		   
		   String nombreAdministrador,
		   String tituloAdministrador,
		   String profecionAdministrador,
		   String emailAdministrador,
		   Integer telefAdministrador,
		   
		   Integer casosNeg,
		   Integer casosEstudio,
		   Integer casosPositi,
		   Integer Recuperados,
		   Integer Defunciones,
		   
		   String nombreHos,
		   String direccionHos,
		   String municipioHos,
		   Integer nMedicos,
		   Integer nAmbulancias,
		   Integer nCuartos,
		   Integer nEnfermos,
		   Integer nCamillas,
		   Integer nLaboratorios,
		   String servicioHos
		   
		   ) {

		this.nombreDirector = nombreDirector; 
		this.tituloDirector =   tituloDirector; 
		this.profecionDirector = profecionDirector;
		this.emailDirector = emailDirector;
		this.telefDirector = telefDirector;
		   
		this.nombreSubdirector = nombreSubdirector; 
		this.tituloSubdirector = tituloSubdirector;
		this.profecionSubdirector = profecionSubdirector;
		this.emailSubdirector = emailSubdirector; 
		this.telefSubdirector = telefSubdirector;
		   
		this.nombreAdministrador = nombreAdministrador;
		this.tituloAdministrador = tituloAdministrador;
		this.profecionAdministrador = profecionAdministrador;
		this.emailAdministrador = emailAdministrador;
		this.telefAdministrador = telefAdministrador;
		   
		this.casosNeg = casosNeg;
		this.casosEstudio = casosEstudio;
		this.casosPositi = casosPositi;
		this.Recuperados = Recuperados;
		this.Defunciones = Defunciones;
		   
		this.nombreHos = nombreHos;
		this.direccionHos = direccionHos;
		this.municipioHos = municipioHos;
		this.nMedicos = nMedicos;
		this.nAmbulancias = nAmbulancias;
		this.nCuartos = nCuartos;
		this.nEnfermos = nEnfermos;
		this.nCamillas = nCamillas;
		this.nLaboratorios = nLaboratorios;
		this.servicioHos = servicioHos;
	}
	
	
}