package com.springboot.form.app.models;

import javax.persistence.*;

@Entity
@Table(name = "director")
public class Director {
	
	@Id
	@Column(name="id")
	private Integer id;
	
	@Column(name="cod_persona")
	private Integer persona;
	
	public Director() {
		
	}

	@Override
	public String toString() {
		return "Director [id=" + id + ", persona=" + persona + "]";
	}

	public Director(Integer id, Integer persona) {
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
