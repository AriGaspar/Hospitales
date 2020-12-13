package com.springboot.form.app.models;

import javax.persistence.Column;
import javax.persistence.*;

@Entity
@Table(name = "covid19")
public class Covid2 {

	@Id
	@Column(name = "id")
	private Integer id;

	@Column(name = "casos_negativos")
	private Integer negativos;

	@Column(name = "casos_estudio")
	private Integer estudio;

	@Column(name = "casos_positivos")
	private Integer positivos;

	@Column(name = "defunciones")
	private Integer defunciones;

	@Column(name = "recuperados")
	private Integer recuperados;

	public Covid2() {

	}

	@Override
	public String toString() {
		return "Covid2 [id=" + id + ", negativos=" + negativos + ", estudio=" + estudio + ", positivos=" + positivos
				+ ", defunciones=" + defunciones + ", recuperados=" + recuperados + "]";
	}

	public Covid2(Integer id, Integer negativos, Integer estudio, Integer positivos, Integer defunciones,
			Integer recuperados) {
		super();
		this.id = id;
		this.negativos = negativos;
		this.estudio = estudio;
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

	public void setNegativos(Integer negativos) {
		this.negativos = negativos;
	}

	public Integer getEstudio() {
		return estudio;
	}

	public void setEstudio(Integer estudio) {
		this.estudio = estudio;
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
