package com.springboot.form.app.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.springboot.form.app.models.Hospital;
import com.springboot.form.app.models.Persona;

@Component
public class informacionDesdeBD implements obtenerInfoDesdeBD{

	private List<Hospital> _hospitales=getHospitalesDesdeBD();
	public List<Hospital> _hospital;

	
	//Metodo que OBTIENE los datos de la base de datos
	@Override
	public List<Hospital> getHospitalesDesdeBD() {
		List<Hospital> hospitales = Arrays.asList(
				new Hospital(1, "Hospital Santa Maria", "Calle 3","Solidaridad","9871243219",5,9,4,2,1,2, "Pediatria-Caca-Caca2-Pedos2-Pedaturbia", 
						new Persona(1,"Pedro May","Doctorado","Medico","pedro@gmail.com","9831235432"),
						new Persona(23,"Tendor Yam","Doctorado","Medico","tendor@gmail.com","9831235432"),
						new Persona(14,"Eduardo May","Doctorado","Medico","eduardo@gmail.com","9831235432"),3),
				new Hospital(2, "Hospital Zaragoza", "Calle 31","Merida","9421543219",1,1,4,2,1,4, "Pediatria-Caca-Caca2-Pedos2-Pedaturbia", 
						new Persona(21,"Albert May","Doctorado","Medico","albert@gmail.com","9831235432"),
						new Persona(12,"Mario May","Doctorado","Medico","mario@gmail.com","9831235432"),
						new Persona(4,"MArcos May","Doctorado","Medico","marcos@gmail.com","9831235432"),6),
				new Hospital(3, "Hospital CAKITO", "Calle 45","Chetumal","9876573119",9,4,4,2,1,1, "Pediatria-Caca-Caca2-Pedos2-Pedaturbia", 
						new Persona(55,"Kiko May","Maestria","Medico","marcos@gmail.com","9831235432"),
						new Persona(323,"Manuel Tamay","Pedos","Medico","marcos@gmail.com","9831235432"),
						new Persona(31,"Carlos May","Popo","Medico","pedro@gmail.com","9831235432"),7),
				new Hospital(4, "Hospital Mendez", "Calle 65","Carrillo York","9276543246",4,1,4,2,1,1, "Pediatria-Caca-Caca2-Pedos2-Pedaturbia", 
						new Persona(432,"Marquitos Mendez","Maestria","Medico","marcos@gmail.com","9831235432"),
						new Persona(42,"Juan Marquez","Pedos","Medico","marcos@gmail.com","9831235432"),
						new Persona(46,"Jose Tun","Nose","Medico","pedro@gmail.com","9831235432"),7)
				); 
		
		for (int i = 0; i < hospitales.size(); i++) {
			hospitales.get(i).get_director().set_deHospital(hospitales.get(i).getNombre());
			hospitales.get(i).get_subdirector().set_deHospital(hospitales.get(i).getNombre());
			hospitales.get(i).get_administrador().set_deHospital(hospitales.get(i).getNombre());
		}
		
		return hospitales;
	}

	//Metodo que MODIFICA los datos en la base de datos
	public void setHospital(List<Hospital> hospital) {
		this._hospitales.set(this.getIndexHospitalDeHospitales(hospital),hospital.get(0)); //se establece el hospital modificado dentro de los demas 
	}
	public void setDirector(Persona director) {
		this._hospital.get(0).set_director(director); //se establece el hospital modificado dentro de los demas 
	}
	public void setSubdirector(Persona subdirector) {
		this._hospital.get(0).set_subdirector(subdirector); //se establece el hospital modificado dentro de los demas 
	}
	public void setAdministrador(Persona administrador) {
		this._hospital.get(0).set_administrador(administrador); //se establece el hospital modificado dentro de los demas 
	}
	public Persona getDirector() {
		return this._hospital.get(0).get_director();
	}
	public Persona getSubdirector() {
		return this._hospital.get(0).get_subdirector();
	}
	public Persona getAdministrador() {
		return this._hospital.get(0).get_administrador();
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
	
	public List<Hospital> getHospitalActual() {
		return this._hospital;
	}
	public void setHospitalActual(List<Hospital> _hospital) {
		this._hospital=_hospital;
	}


}
