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
	
	private Integer id_director;
	private Integer id_subdirector;
	private Integer id_administrador;
	private Integer id_covid;
	
	public Hospital() {
		
	}
	public Hospital(Integer id, String nombre, String direccion, String municipio, String telefono, Integer noMedicos,
			Integer noEnfermeros, Integer noAmbulacias, Integer noCamillas, Integer noCuartos, Integer noLab,
			String servicios, Integer id_director, Integer id_subdirector, Integer id_administrador, Integer id_covid) {
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
		this.id_director = id_director;
		this.id_subdirector = id_subdirector;
		this.id_administrador = id_administrador;
		this.id_covid = id_covid;
	}

	@Override
	public String toString() {
		return "Hospital [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", municipio=" + municipio
				+ ", telefono=" + telefono + ", noMedicos=" + noMedicos + ", noEnfermeros=" + noEnfermeros
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
