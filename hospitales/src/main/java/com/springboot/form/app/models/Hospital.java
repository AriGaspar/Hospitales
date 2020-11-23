package com.springboot.form.app.models;

public class Hospital	{
	
	//Atributos
	private Integer id;
	private String nombre;
	private String direccion;
	private String municipio;
	private String telefono;
	private Integer noMedicos;
	private Integer noEnfermeros;
	

	private Integer noAmbulacias;
	private Integer noCamillas;
	private Integer noCuartos;
	private Integer noLab;

	private String servicios;
	
	public Hospital() {
		
	}
	public Hospital(Integer id, String nombre, String direccion, String municipio, String telefono, Integer noMedicos,
			Integer noEnfermeros, Integer noAmbulacias, Integer noCamillas, Integer noCuartos, Integer noLab,
			String servicios) {
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.municipio = municipio;
		this.telefono = telefono;
		this.noMedicos = noMedicos;
		this.noEnfermeros = noEnfermeros;
		this.noAmbulacias = noAmbulacias;
		this.noCamillas = noCamillas;
		this.noCuartos = noCuartos;
		this.noLab = noLab;
		this.servicios = servicios;
	}

	@Override
	public String toString() {
		return "Hospital [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", municipio=" + municipio
				+ ", telefono=" + telefono + ", noMedicos=" + noMedicos + ", noEnfermeros=" + noEnfermeros
				+ ", noAmbulacias=" + noAmbulacias + ", noCamillas=" + noCamillas + ", noCuartos=" + noCuartos
				+ ", noLab=" + noLab + ", servicios=" + servicios + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Integer getNoMedicos() {
		return noMedicos;
	}

	public void setNoMedicos(Integer noMedicos) {
		this.noMedicos = noMedicos;
	}

	public Integer getNoEnfermeros() {
		return noEnfermeros;
	}

	public void setNoEnfermeros(Integer noEnfermeros) {
		this.noEnfermeros = noEnfermeros;
	}

	public Integer getNoAmbulacias() {
		return noAmbulacias;
	}

	public void setNoAmbulacias(Integer noAmbulacias) {
		this.noAmbulacias = noAmbulacias;
	}

	public Integer getNoCamillas() {
		return noCamillas;
	}

	public void setNoCamillas(Integer noCamillas) {
		this.noCamillas = noCamillas;
	}

	public Integer getNoCuartos() {
		return noCuartos;
	}

	public void setNoCuartos(Integer noCuartos) {
		this.noCuartos = noCuartos;
	}

	public Integer getNoLab() {
		return noLab;
	}

	public void setNoLab(Integer noLab) {
		this.noLab = noLab;
	}

	public String getServicios() {
		return servicios;
	}

	public void setServicios(String servicios) {
		this.servicios = servicios;
	}

	
	
}
