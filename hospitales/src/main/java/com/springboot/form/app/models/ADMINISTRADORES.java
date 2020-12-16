package com.springboot.form.app.models;

import javax.persistence.*;

@Entity
@Table(name = "administrador")
public class ADMINISTRADORES {
	
	@Id
	@Column(name="id")
	private Integer id;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_persona")
	private Persona persona;
	
	public ADMINISTRADORES() {
		
	}

	@Override
	public String toString() {
		return "Administrador [id=" + id + ", persona=" + persona + "]";
	}

	public ADMINISTRADORES(Integer id, Persona persona) {
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
