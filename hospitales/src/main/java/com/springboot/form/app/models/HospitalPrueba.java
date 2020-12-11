package com.springboot.form.app.models;

import javax.persistence.Column;
import javax.persistence.*;

@Entity
@Table(name = "hospital")
public class HospitalPrueba {

	// Atributos
	@Id
	@Column(name="id")
	private Integer id;
	
	@Column(name="Nombre")
	private String nombre;
	
	@Column(name="Direccion")
	private String direccion;
	
	@Column(name="Municipio")
	private String municipio;
	
	@Column(name="Telefono")
	private String telefono;
	
	@Column(name="No_Medicos")
	private Integer noMedicos;
	
	@Column(name="No_Enfermeros")
	private Integer noEnfermeros;
	
	@Column(name="No_Ambulancias")
	private Integer noAmbulacias;
	
	@Column(name="No_Camillas")
	private Integer noCamillas;
	
	@Column(name="No_Cuartos")
	private Integer noCuartos;
	
	@Column(name="No_Laboratorios")
	private Integer noLab;

	@Column(name="Sevicios")
	private String servicios;

	@Column(name="id_Director")
	private Integer id_director;
	
	@Column(name="id_Subdirector")
	private Integer id_subdirector;
	
	@Column(name="id_Administrador")
	private Integer id_administrador;
	
	@Column(name="id_Covid")
	private Integer id_covid;

	public HospitalPrueba() {
	}

	@Override
	public String toString() {
		return "HospitalPrueba [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", municipio="
				+ municipio + ", telefono=" + telefono + ", noMedicos=" + noMedicos + ", noEnfermeros=" + noEnfermeros
				+ ", noAmbulacias=" + noAmbulacias + ", noCamillas=" + noCamillas + ", noCuartos=" + noCuartos
				+ ", noLab=" + noLab + ", servicios=" + servicios + ", id_director=" + id_director + ", id_subdirector="
				+ id_subdirector + ", id_administrador=" + id_administrador + ", id_covid=" + id_covid + "]";
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

	public Integer getId_director() {
		return id_director;
	}

	public void setId_director(Integer id_director) {
		this.id_director = id_director;
	}

	public Integer getId_subdirector() {
		return id_subdirector;
	}

	public void setId_subdirector(Integer id_subdirector) {
		this.id_subdirector = id_subdirector;
	}

	public Integer getId_administrador() {
		return id_administrador;
	}

	public void setId_administrador(Integer id_administrador) {
		this.id_administrador = id_administrador;
	}

	public Integer getId_covid() {
		return id_covid;
	}

	public void setId_covid(Integer id_covid) {
		this.id_covid = id_covid;
	}

}
