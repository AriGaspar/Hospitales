package com.springboot.form.app.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.springboot.form.app.dao.IAdministradorRepo;
import com.springboot.form.app.dao.ICovidRepo;
import com.springboot.form.app.dao.IDirectorRepo;
import com.springboot.form.app.dao.IHospital2Repo;
import com.springboot.form.app.dao.IPersona2Repo;
import com.springboot.form.app.dao.ISubdirectorRepo2;
import com.springboot.form.app.models.ADMINISTRADORES;
import com.springboot.form.app.models.Administrador;
import com.springboot.form.app.models.Covid;
import com.springboot.form.app.models.Covid2;
import com.springboot.form.app.models.DIRECTORES;
import com.springboot.form.app.models.Director;
import com.springboot.form.app.models.HOSPITALS;
import com.springboot.form.app.models.Hospital;
import com.springboot.form.app.models.Hospital2;
import com.springboot.form.app.models.Persona;
import com.springboot.form.app.models.Persona2;
import com.springboot.form.app.models.SUBDIRECTORES;
import com.springboot.form.app.models.Subdirector;

@Component
public class informacionDesdeBD implements obtenerInfoDesdeBD{
	@Autowired
	private IHospital2Repo h;
	@Autowired
	private ISubdirectorRepo2 s;
	@Autowired
	private IDirectorRepo d;
	@Autowired
	private IAdministradorRepo a;
	@Autowired
	private IPersona2Repo p;
	@Autowired
	private ICovidRepo c;

	private List<Hospital> _hospitales=new ArrayList<Hospital>();
	public List<Hospital> _hospital=new ArrayList<Hospital>();
	public List<Persona> _personal=new ArrayList<Persona>();

	public List<Hospital> getHospitalesDesdeBD() {
		List<HOSPITALS> hospital=this.h.findAll();
		List<Hospital> hp=new ArrayList<Hospital>();
//		System.out.println(hospital.get(0).getDirector().getId());
		for (int i = 0; i < hospital.size(); i++) {
			HOSPITALS un=hospital.get(i);
			hp.add(new Hospital(un.getId(),un.getNombre(),un.getDireccion(),un.getMunicipio(),un.getTelefono(),un.getNoMedicos(),un.getNoEnfermeros(),un.getNoAmbulacias(),un.getNoCamillas(),un.getNoCuartos(),un.getNoLab(), un.getServicios(), 
					new Persona(un.getDirector().getId(),
							un.getDirector().getPersona().getNombre(),
							un.getDirector().getPersona().getTitulo(),
							un.getDirector().getPersona().getProfesion(),
							un.getDirector().getPersona().getEmail(),
							un.getDirector().getPersona().getTelefono()),
					new Persona(un.getSubdirector().getId(),
							un.getSubdirector().getPersona().getNombre(),
							un.getSubdirector().getPersona().getTitulo(),
							un.getSubdirector().getPersona().getProfesion(),
							un.getSubdirector().getPersona().getEmail(),
							un.getSubdirector().getPersona().getTelefono()),
					new Persona(un.getAdministrador().getId(),
							un.getAdministrador().getPersona().getNombre(),
							un.getAdministrador().getPersona().getTitulo(),
							un.getAdministrador().getPersona().getProfesion(),
							un.getAdministrador().getPersona().getEmail(),
							un.getAdministrador().getPersona().getTelefono()),
					new Covid(un.getCovid().getId(),un.getCovid().getNegativos(),un.getCovid().getEstudio(),un.getCovid().getPositivos(),un.getCovid().getDefunciones(),un.getCovid().getRecuperados())));
		}
		
		return hp;
	}

	//Metodo que MODIFICA los datos en la base de datos
	public void setHospital(Hospital hospital) {
		
		
		
		List<HOSPITALS> hospitals=this.h.findAll();
		
		for (int i = 0; i < hospitals.size(); i++) {
			if(hospitals.get(i).getId()==hospital.getId()) {
				System.out.println("QUE ONDAAAA");
				
				HOSPITALS hos=new HOSPITALS(hospital.getId(), hospital.getNombre(), hospital.getDireccion(),hospital.getMunicipio(),hospital.getTelefono(),hospital.getNoMedicos(),hospital.getNoEnfermeros(),hospital.getNoAmbulacias(),hospital.getNoCamillas(),hospital.getNoCuartos(),hospital.getNoLab(), hospital.getServicios(), 
						hospitals.get(i).getDirector(),
						hospitals.get(i).getSubdirector(),
						hospitals.get(i).getAdministrador(),
						hospitals.get(i).getCovid());
				
				this.h.save(hos);
				break;
			}
		}
		
		
		
		
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

	public void vaciarHospitalActual() {
		this._hospital.clear();
	}
	
	public void setNewHospital(HOSPITALS hs) {
		this.h.save(hs);
	}
	
		
	public void setPersonal(Persona p) {
		Persona2 persona = new Persona2(p.getCodigo(),p.getNombre(),p.getTitulo(),p.getProfesion(),p.getEmail(),p.getTelefono());
		this.p.save(persona);
		
	}
	
	public List<Persona> getPersonal(){
		List<HOSPITALS> hospital = this.h.findAll();
		List<Persona> personal = new ArrayList<>();
		
		for (int i = 0; i < hospital.size(); i++) {
			HOSPITALS hTemp=hospital.get(i);
			
			hTemp.getDirector().getPersona().setCargo("Director");
			hTemp.getDirector().getPersona().setDeHospital(hTemp.getNombre());
			personal.add(hTemp.getDirector().getPersona());
			
			hTemp.getSubdirector().getPersona().setCargo("Subdirector");
			hTemp.getSubdirector().getPersona().setDeHospital(hTemp.getNombre());
			personal.add(hTemp.getSubdirector().getPersona());
			
			hTemp.getAdministrador().getPersona().setCargo("Administrador");
			hTemp.getAdministrador().getPersona().setDeHospital(hTemp.getNombre());
			personal.add(hTemp.getAdministrador().getPersona());
		}
		
		return personal;
	}
	
	public List<Covid> getRegistrosCovid(){
		List<HOSPITALS> hospital = this.h.findAll();
		List<Covid> covidR=new ArrayList<>();
		
		for (int i = 0; i < hospital.size(); i++) {
			HOSPITALS hTemp=hospital.get(i);
			Covid cIn=new Covid(hTemp.getCovid().getId(),
					hTemp.getCovid().getNegativos(),
					hTemp.getCovid().getEstudio(),
					hTemp.getCovid().getPositivos(),
					hTemp.getCovid().getDefunciones(),
					hTemp.getCovid().getRecuperados());
			cIn.setDeHospital(hTemp.getNombre());
			covidR.add(cIn);
			
		}
		
		
		return covidR;
	}
	
	public void setCovid(Covid c) {
		this.c.save(new Covid2(c.getId(),c.getNegativos(),c.getEstudios(),c.getPositivos(),c.getDefunciones(),c.getRecuperados()));
	}
	
	public int generateUniqueId() {      
        UUID idOne = UUID.randomUUID();
        String str=""+idOne;        
        int uid=str.hashCode();
        String filterStr=""+uid;
        str=filterStr.replaceAll("-", "");
        return Integer.parseInt(str.substring(0, 3));
    }
	
}
