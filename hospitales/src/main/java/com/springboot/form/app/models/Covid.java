package com.springboot.form.app.models;

public class Covid {

	private Integer id;
	private String deHospital;
	private Integer negativos;
	private Integer estudios;
	private Integer positivos;
	private Integer defunciones;
	private Integer recuperados;
	
	public Covid(Integer id, Integer negativos, Integer estudios, Integer positivos, Integer defunciones,
			Integer recuperados) {
		this.id = id;
		this.negativos = negativos;
		this.estudios = estudios;
		this.positivos = positivos;
		this.defunciones = defunciones;
		this.recuperados = recuperados;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNegativos() {
		return negativos;
	}

	public void setDeHospital(String deHospital) {
		this.deHospital = deHospital;
	}
	
	public String getDeHospitales() {
		return this.deHospital;
	}

	public void setNegativos(Integer negativos) {
		this.negativos = negativos;
	}

	public Integer getEstudios() {
		return estudios;
	}

	public void setEstudios(Integer estudios) {
		this.estudios = estudios;
	}

	public Integer getPositivos() {
		return positivos;
	}

	public void setPositivos(Integer positivos) {
		this.positivos = positivos;
	}

	public Integer getDefunciones() {
		return defunciones;
	}

	public void setDefunciones(Integer defunciones) {
		this.defunciones = defunciones;
	}

	public Integer getRecuperados() {
		return recuperados;
	}

	public void setRecuperados(Integer recuperados) {
		this.recuperados = recuperados;
	}
	
	
	
	
	
}
