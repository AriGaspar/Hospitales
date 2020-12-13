package com.springboot.form.app.models;

import javax.persistence.*;

@Entity
@Table(name = "administrador")
public class Administrador {
	
	@Id
	@Column(name="id")
	private Integer id;
	
	@Column(name="id_persona")
	private Integer persona;
	
	public Administrador() {
		
	}

	@Override
	public String toString() {
		return "Administrador [id=" + id + ", persona=" + persona + "]";
	}

	public Administrador(Integer id, Integer persona) {
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

	public Integer getPersona() {
		return persona;
	}

	public void setPersona(Integer persona) {
		this.persona = persona;
	}

}
