package com.springboot.form.app.models;

public class Persona {

	private Integer _codigo;
	private String _nombre;
	private String _titulo;
	private String _profesion;
	private String _email;
	private String _telefono;
	
	public Persona() {
	
	}

	
	
	
	
	public Persona(Integer _codigo, String _nombre, String _titulo, String _profesion, String _email,
			String _telefono) {
		this._codigo = _codigo;
		this._nombre = _nombre;
		this._titulo = _titulo;
		this._profesion = _profesion;
		this._email = _email;
		this._telefono = _telefono;
	}





	public Integer get_codigo() {
		return _codigo;
	}

	public void set_codigo(Integer _codigo) {
		this._codigo = _codigo;
	}

	public String get_nombre() {
		return _nombre;
	}

	public void set_nombre(String _nombre) {
		this._nombre = _nombre;
	}

	public String get_titulo() {
		return _titulo;
	}

	public void set_titulo(String _titulo) {
		this._titulo = _titulo;
	}

	public String get_profesion() {
		return _profesion;
	}

	public void set_profesion(String _profesion) {
		this._profesion = _profesion;
	}

	public String get_email() {
		return _email;
	}

	public void set_email(String _email) {
		this._email = _email;
	}

	public String get_telefono() {
		return _telefono;
	}

	public void set_telefono(String _telefono) {
		this._telefono = _telefono;
	}
	
	
	
}
