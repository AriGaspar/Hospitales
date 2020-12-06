package com.springboot.form.app.models;

public class Persona {

	private Integer codigo;
	private String cargo;
	private String nombre;
	private String titulo;
	private String profesion;
	private String email;
	private String telefono;
	private String dehospital;
	
	public Persona() {
	
	}

	public Persona(Integer _codigo, String _nombre, String _titulo, String _profesion, String _email,
			String _telefono) {
		this.codigo = _codigo;
		this.nombre = _nombre;
		this.titulo = _titulo;
		this.profesion = _profesion;
		this.email = _email;
		this.telefono = _telefono;
	}

	
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer _codigo) {
		this.codigo = _codigo;
	}

	public String getCargo() {
		return this.cargo;
	}

	public void setCargo(String _cargo) {
		this.cargo = _cargo;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String _nombre) {
		this.nombre = _nombre;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String _titulo) {
		this.titulo = _titulo;
	}

	public String getProfesion() {
		return profesion;
	}

	public void setProfesion(String _profesion) {
		this.profesion = _profesion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String _email) {
		this.email = _email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String _telefono) {
		this.telefono = _telefono;
	}
	
	public String getDeHospital() {
		return this.dehospital;
	}

	public void setDeHospital(String _dehospital) {
		this.dehospital = _dehospital;
	}
	
	
	
}
