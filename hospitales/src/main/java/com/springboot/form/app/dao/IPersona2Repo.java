package com.springboot.form.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.form.app.models.Hospital2;
import com.springboot.form.app.models.Persona2;

public interface IPersona2Repo extends JpaRepository<Persona2, Integer>{
	
}
