package com.springboot.form.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.springboot.form.app.models.HOSPITALS;
import com.springboot.form.app.models.Hospital2;


@Repository
public interface IHospital2Repo extends JpaRepository<HOSPITALS, Integer>{
	
}
