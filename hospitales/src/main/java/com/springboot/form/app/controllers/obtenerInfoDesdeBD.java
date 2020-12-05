package com.springboot.form.app.controllers;

import java.util.List;

import com.springboot.form.app.models.Hospital;
import com.springboot.form.app.models.Persona;

public interface obtenerInfoDesdeBD {
	
	public List<Hospital> getHospitalesDesdeBD();
	public List<Hospital> getHospitalesActuales();
	public void vaciarHospital();
	public void setHospital(List<Hospital> hospital);
	public List<Persona> getPersonalActual();
	
	public List<Hospital> getHospitalActual();

	
}
