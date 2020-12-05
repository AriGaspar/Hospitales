package com.springboot.form.app.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.springboot.form.app.models.Hospital;
import com.springboot.form.app.models.Persona;

@Component
public class informacionDesdeBD implements obtenerInfoDesdeBD{

	private List<Hospital> _hospitales=getHospitalesDesdeBD();
	private List<Hospital> _personalG=getHospitalesDesdeBD();
	
	//Metodo que OBTIENE los datos de la base de datos
	@Override
	public List<Hospital> getHospitalesDesdeBD() {
		List<Hospital> hospitales = Arrays.asList(
				new Hospital(1, "Hospital Santa Maria", "Calle 3","Solidaridad","9871243219",5,9,4,2,1,2, "Pediatria-Caca-Caca2-Pedos2-Pedaturbia", 1,4,2,3),
				new Hospital(2, "Hospital Zaragoza", "Calle 31","Merida","9421543219",1,1,4,2,1,4, "Pediatria-Caca-Caca2-Pedos2-Pedaturbia", 3,4,2,6),
				new Hospital(3, "Hospital CAKITO", "Calle 45","Chetumal","9876573119",9,4,4,2,1,1, "Pediatria-Caca-Caca2-Pedos2-Pedaturbia", 3,6,2,7),
				new Hospital(4, "Hospital Mendez", "Calle 65","Carrillo York","9276543246",4,1,4,2,1,1, "Pediatria-Caca-Caca2-Pedos2-Pedaturbia", 2,8,1,7)
				);
		return hospitales;
	}
	public List<Persona> getPersonalDesdeBD() {
		List<Persona> personas = Arrays.asList(
				new Persona(1,"Pedro May","Doctorado","Medico","pedro@gmail.com","9831235432"),
				new Persona(1,"Pedro May","Doctorado","Medico","pedro@gmail.com","9831235432"),
				new Persona(1,"Pedro May","Doctorado","Medico","pedro@gmail.com","9831235432"),
				new Persona(1,"Pedro May","Doctorado","Medico","pedro@gmail.com","9831235432"),
				new Persona(1,"Pedro May","Doctorado","Medico","pedro@gmail.com","9831235432"),
				new Persona(1,"Pedro May","Doctorado","Medico","pedro@gmail.com","9831235432"),
				new Persona(1,"Pedro May","Doctorado","Medico","pedro@gmail.com","9831235432")
				);
		return personas;
	}
	
	//Metodo que MODIFICA los datos en la base de datos
	public void setHospital(List<Hospital> hospital) {
		this._hospitales.set(this.getIndexHospitalDeHospitales(hospital),hospital.get(0)); //se establece el hospital modificado dentro de los demas 
	}
	
	public Integer getIndexHospitalDeHospitales(List<Hospital> hospital) {
		for (int i = 0; i < this._hospitales.size(); i++) {
			if(this._hospitales.get(i).getId()==hospital.get(0).getId()) {
				return i;
			}
		}
		return null;
	}
	
	
	@Override
	public List<Hospital> getHospitalesActuales() {
		return this._hospitales;
	}

}
