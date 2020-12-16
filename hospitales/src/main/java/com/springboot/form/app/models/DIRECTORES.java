package com.springboot.form.app.models;

import javax.persistence.*;

@Entity
@Table(name = "director")
public class DIRECTORES {
	
	@Id
	@Column(name="id")
	private Integer id;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cod_persona")
	private Persona persona;
	
	public DIRECTORES() {
		
	}

	@Override
	public String toString() {
		return "Director [id=" + id + ", persona=" + persona + "]";
	}

	public DIRECTORES(Integer id, Persona persona) {
		super();
		this.id = id;
		this.persona = persona;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}
