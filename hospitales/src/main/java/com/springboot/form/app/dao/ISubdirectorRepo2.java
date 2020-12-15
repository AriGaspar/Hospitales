package com.springboot.form.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.form.app.models.Director;
import com.springboot.form.app.models.Subdirector;

public interface ISubdirectorRepo2 extends JpaRepository<Subdirector, Integer>{
	
}
