package com.springboot.form.app.controllers;

import java.util.List;

import com.springboot.form.app.models.Covid;
import com.springboot.form.app.models.Hospital;
import com.springboot.form.app.models.Persona;

public interface obtenerInfoDesdeBD {
	//
	public List<Hospital> getHospitalesDesdeBD();
	public List<Hospital> getHospitalesActuales();
	public void setHospital(Hospital hospital);

	public void setHospitalActual(List<Hospital> _hospital);
	public List<Hospital> getHospitalActual();
	public List<Hospital> getG();
	public void vaciarHospitalActual();
	public void setNewHospital(Hospital h);
	public List<Persona> getPersonal();
	public void setPersonal(Persona p);
	public List<Covid> getRegistrosCovid();
	public void setCovid(Covid c);

	
}
