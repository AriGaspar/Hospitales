package com.springboot.form.app.models;

public class Hospital	{
	
	//Atributos
	private Integer id;
	private String nombre;
	private boolean activo;
	private String lugar;
	private String servicios;
	
	//Constructor
	public Hospital(Integer id, String nombre, boolean activo, String lugar, String servicios) {
		this.id = id;
		this.nombre = nombre;
		this.activo = activo;
		this.lugar = lugar;
		this.servicios = servicios;
	}
	
	public Hospital() {
		
	}

	//Metodos Getters 
	public Integer getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public boolean isActivo() {
		return activo;
	}

	public String getLugar() {
		return lugar;
	}

	public String getServicios() {
		return servicios;
	}

	//Metodos Setters
	public void setId(Integer id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public void setServicios(String servicios) {
		this.servicios = servicios;
	}
}
