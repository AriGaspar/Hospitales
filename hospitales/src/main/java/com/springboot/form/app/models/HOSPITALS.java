package com.springboot.form.app.models;

import javax.persistence.*;
@Entity
@Table(name="hospital")
public class HOSPITALS	{
	
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

	@Column(name="Servicios")
	private String servicios;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_Director")
	private DIRECTORES director;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_Subdirector")
	private SUBDIRECTORES subdirector;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_Administrador")
	private ADMINISTRADORES administrador;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_Covid")
	private Covid2 covid;
	
	public HOSPITALS() {
		
	}
	public HOSPITALS(Integer id, String nombre, String direccion, String municipio, String telefono, Integer noMedicos,
			Integer noEnfermeros, Integer noAmbulacias, Integer noCamillas, Integer noCuartos, Integer noLab,
			String servicios, DIRECTORES director,SUBDIRECTORES subdirector,ADMINISTRADORES administrador , Covid2 covid) {
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
		this.director = director;
		this.subdirector = subdirector;
		this.administrador = administrador;
		this.covid =covid;
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
	
	
	

	public DIRECTORES getDirector() {
		return director;
	}
	public void setDirector(DIRECTORES director) {
		this.director = director;
	}
	public SUBDIRECTORES getSubdirector() {
		return subdirector;
	}
	public void setSubdirector(SUBDIRECTORES subdirector) {
		this.subdirector = subdirector;
	}
	public ADMINISTRADORES getAdministrador() {
		return administrador;
	}
	public void setAdministrador(ADMINISTRADORES administrador) {
		this.administrador = administrador;
	}
	public Covid2 getCovid() {
		return covid;
	}
	public void setCovid(Covid2 covid) {
		this.covid = covid;
	}
	public String getServiciosSeparadosSaltosLinea() {
		
		String[] serviciosSeparados=this.servicios.split("-");
		String serviciosSeparadosConSaltosDeLinea = serviciosSeparados[0];
		
		for (int i = 1 ; i < serviciosSeparados.length ; i++) {
			serviciosSeparadosConSaltosDeLinea+= ", "+serviciosSeparados[i];
		}
		
		return serviciosSeparadosConSaltosDeLinea;
	}
	
	
		
}
