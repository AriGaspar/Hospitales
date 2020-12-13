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

	public String getNombreDirector() {
		return nombreDirector;
	}

	public void setNombreDirector(String nombreDirector) {
		this.nombreDirector = nombreDirector;
	}

	public String getTituloDirector() {
		return tituloDirector;
	}

	public void setTituloDirector(String tituloDirector) {
		this.tituloDirector = tituloDirector;
	}

	public String getProfecionDirector() {
		return profecionDirector;
	}

	public void setProfecionDirector(String profecionDirector) {
		this.profecionDirector = profecionDirector;
	}

	public String getEmailDirector() {
		return emailDirector;
	}

	public void setEmailDirector(String emailDirector) {
		this.emailDirector = emailDirector;
	}

	public Integer getTelefDirector() {
		return telefDirector;
	}

	public void setTelefDirector(Integer telefDirector) {
		this.telefDirector = telefDirector;
	}

	public String getNombreSubdirector() {
		return nombreSubdirector;
	}

	public void setNombreSubdirector(String nombreSubdirector) {
		this.nombreSubdirector = nombreSubdirector;
	}

	public String getTituloSubdirector() {
		return tituloSubdirector;
	}

	public void setTituloSubdirector(String tituloSubdirector) {
		this.tituloSubdirector = tituloSubdirector;
	}

	public String getProfecionSubdirector() {
		return profecionSubdirector;
	}

	public void setProfecionSubdirector(String profecionSubdirector) {
		this.profecionSubdirector = profecionSubdirector;
	}

	public String getEmailSubdirector() {
		return emailSubdirector;
	}

	public void setEmailSubdirector(String emailSubdirector) {
		this.emailSubdirector = emailSubdirector;
	}

	public Integer getTelefSubdirector() {
		return telefSubdirector;
	}

	public void setTelefSubdirector(Integer telefSubdirector) {
		this.telefSubdirector = telefSubdirector;
	}

	public String getNombreAdministrador() {
		return nombreAdministrador;
	}

	public void setNombreAdministrador(String nombreAdministrador) {
		this.nombreAdministrador = nombreAdministrador;
	}

	public String getTituloAdministrador() {
		return tituloAdministrador;
	}

	public void setTituloAdministrador(String tituloAdministrador) {
		this.tituloAdministrador = tituloAdministrador;
	}

	public String getProfecionAdministrador() {
		return profecionAdministrador;
	}

	public void setProfecionAdministrador(String profecionAdministrador) {
		this.profecionAdministrador = profecionAdministrador;
	}

	public String getEmailAdministrador() {
		return emailAdministrador;
	}

	public void setEmailAdministrador(String emailAdministrador) {
		this.emailAdministrador = emailAdministrador;
	}

	public Integer getTelefAdministrador() {
		return telefAdministrador;
	}

	public void setTelefAdministrador(Integer telefAdministrador) {
		this.telefAdministrador = telefAdministrador;
	}

	public Integer getCasosNeg() {
		return casosNeg;
	}

	public void setCasosNeg(Integer casosNeg) {
		this.casosNeg = casosNeg;
	}

	public Integer getCasosEstudio() {
		return casosEstudio;
	}

	public void setCasosEstudio(Integer casosEstudio) {
		this.casosEstudio = casosEstudio;
	}

	public Integer getCasosPositi() {
		return casosPositi;
	}

	public void setCasosPositi(Integer casosPositi) {
		this.casosPositi = casosPositi;
	}

	public Integer getRecuperados() {
		return Recuperados;
	}

	public void setRecuperados(Integer recuperados) {
		Recuperados = recuperados;
	}

	public Integer getDefunciones() {
		return Defunciones;
	}

	public void setDefunciones(Integer defunciones) {
		Defunciones = defunciones;
	}

	public String getNombreHos() {
		return nombreHos;
	}

	public void setNombreHos(String nombreHos) {
		this.nombreHos = nombreHos;
	}

	public String getDireccionHos() {
		return direccionHos;
	}

	public void setDireccionHos(String direccionHos) {
		this.direccionHos = direccionHos;
	}

	public String getMunicipioHos() {
		return municipioHos;
	}

	public void setMunicipioHos(String municipioHos) {
		this.municipioHos = municipioHos;
	}

	public Integer getnMedicos() {
		return nMedicos;
	}

	public void setnMedicos(Integer nMedicos) {
		this.nMedicos = nMedicos;
	}

	public Integer getnAmbulancias() {
		return nAmbulancias;
	}

	public void setnAmbulancias(Integer nAmbulancias) {
		this.nAmbulancias = nAmbulancias;
	}

	public Integer getnCuartos() {
		return nCuartos;
	}

	public void setnCuartos(Integer nCuartos) {
		this.nCuartos = nCuartos;
	}

	public Integer getnEnfermos() {
		return nEnfermos;
	}

	public void setnEnfermos(Integer nEnfermos) {
		this.nEnfermos = nEnfermos;
	}

	public Integer getnCamillas() {
		return nCamillas;
	}

	public void setnCamillas(Integer nCamillas) {
		this.nCamillas = nCamillas;
	}

	public Integer getnLaboratorios() {
		return nLaboratorios;
	}

	public void setnLaboratorios(Integer nLaboratorios) {
		this.nLaboratorios = nLaboratorios;
	}

	public String getServicioHos() {
		return servicioHos;
	}

	public void setServicioHos(String servicioHos) {
		this.servicioHos = servicioHos;
	}
	
	
}