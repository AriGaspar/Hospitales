package com.springboot.form.app.models;

import javax.persistence.*;

@Entity
@Table(name="persona")
public class Persona2 {

	@Id
	@Column(name="Codigo")
	private Integer codigo;
	
	@Column(name="Nombre")
	private String nombre;
	
	@Column(name="Titulo")
	private String titulo;
	
	@Column(name="Profesion")
	private String profesion;
	
	@Column(name="Correo_electronico")
	private String email;
	
	@Column(name="Telefono")
	private String telefono;
	
	public Persona2() {
	
	}

	@Override
	public String toString() {
		return "Persona2 [codigo=" + codigo + ", nombre=" + nombre + ", titulo=" + titulo + ", profesion=" + profesion
				+ ", email=" + email + ", telefono=" + telefono + "]";
	}

	public Persona2(Integer codigo, String nombre, String titulo, String profesion, String email, String telefono) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.titulo = titulo;
		this.profesion = profesion;
		this.email = email;
		this.telefono = telefono;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getProfesion() {
		return profesion;
	}

	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
}
