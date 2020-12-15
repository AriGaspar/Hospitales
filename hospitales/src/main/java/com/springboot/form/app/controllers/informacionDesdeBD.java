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
import com.springboot.form.app.models.Administrador;
import com.springboot.form.app.models.Covid;
import com.springboot.form.app.models.Covid2;
import com.springboot.form.app.models.Director;
import com.springboot.form.app.models.Hospital;
import com.springboot.form.app.models.Hospital2;
import com.springboot.form.app.models.Persona;
import com.springboot.form.app.models.Persona2;
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

	//Metodo que OBTIENE los datos de la base de datos
	@Override
	public List<Hospital> getHospitalesDesdeBD() {
		
		this._hospitales=getG();
		return getG();
	}

	//Metodo que MODIFICA los datos en la base de datos
	public void setHospital(Hospital hospital) {
		Hospital hs=hospital;
		Hospital2 hospita=new Hospital2(hs.getId(),
										hs.getNombre(),
										hs.getDireccion(),
										hs.getMunicipio(),
										hs.getTelefono().toString(),
										hs.getNoMedicos(),
										hs.getNoEnfermeros(),
										hs.getNoAmbulacias(),
										hs.getNoCamillas(),
										hs.getNoCuartos(),
										hs.getNoLab(),
										hs.getServicios(),
										getDirectivosOCovidIDs("director", hs.getId()),
										getDirectivosOCovidIDs("subdirector", hs.getId()),
										getDirectivosOCovidIDs("administrador", hs.getId()),
										getDirectivosOCovidIDs("covid", hs.getId()));
		
		this.h.save(hospita);
	}

	public Integer getDirectivosOCovidIDs(String que,Integer hid) {
		List<Hospital2> h2 = this.h.findAll();
		
		Integer idFinal=0;
		
		for (int i = 0; i <h2.size() ; i++) {
			if(hid==h2.get(i).getId()) {
				switch(que) {
				case "director":
						idFinal=h2.get(i).getDirector();
					break;
				case "subdirector":
						idFinal=h2.get(i).getSubdirector();
					break;
				case "administrador":
						idFinal=h2.get(i).getAdministrador();
					break;
				case "covid":
						idFinal=h2.get(i).getCovid();
					break;
				}
			}
			
		}
		
		return idFinal;
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
	
	public void setNewHospital(Hospital hs) {
		Integer dirId=generateUniqueId();
		Integer subId=generateUniqueId();
		Integer admId=generateUniqueId();
		
		Persona2 director = new Persona2(hs.get_director().getCodigo(),hs.get_director().getNombre(),hs.get_director().getTitulo(),hs.get_director().getProfesion(),hs.get_director().getEmail(),hs.get_director().getTelefono());
		Persona2 subdirector = new Persona2(hs.get_subdirector().getCodigo(),hs.get_subdirector().getNombre(),hs.get_subdirector().getTitulo(),hs.get_subdirector().getProfesion(),hs.get_subdirector().getEmail(),hs.get_subdirector().getTelefono());
		Persona2 administrador = new Persona2(hs.get_administrador().getCodigo(),hs.get_administrador().getNombre(),hs.get_administrador().getTitulo(),hs.get_administrador().getProfesion(),hs.get_administrador().getEmail(),hs.get_administrador().getTelefono());
		Covid2 covid = new Covid2(hs.get_covid().getId(),hs.get_covid().getNegativos(),hs.get_covid().getEstudios(),hs.get_covid().getPositivos(),hs.get_covid().getDefunciones(),hs.get_covid().getRecuperados());
		
		Hospital2 hospital=new Hospital2(hs.getId(),
				hs.getNombre(),
				hs.getDireccion(),
				hs.getMunicipio(),
				hs.getTelefono().toString(),
				hs.getNoMedicos(),
				hs.getNoEnfermeros(),
				hs.getNoAmbulacias(),
				hs.getNoCamillas(),
				hs.getNoCuartos(),
				hs.getNoLab(),
				hs.getServicios(),
				dirId,
				subId,
				admId,
				hs.get_covid().getId());
		
		//Añadiendo Persona Director
		this.p.save(director);
		//Añadiendo Persona Subdirector
		this.p.save(subdirector);
		//Añadiendo Persona Adminstrador
		this.p.save(administrador);
		//Añadiendo Registro covid
		this.c.save(covid);
		//Añadiendo Director
		this.d.save(new Director(dirId,director.getCodigo()));
		//Añadiendo Subdirector
		this.s.save(new Subdirector(subId,subdirector.getCodigo()));
		//Añadiendo Adminstrador
		this.a.save(new Administrador(admId,administrador.getCodigo()));
		//Añadiendo hospitales
		this.h.save(hospital);
	}
	
	public List<Hospital> getG(){
		List<Hospital> hospitales = new ArrayList<>();
		List<Persona> personal = new ArrayList<>();
		
		List<Hospital2> h = this.h.findAll();
		List<Persona2> persona = this.p.findAll();
		List<Director> director = this.d.findAll();
		List<Subdirector> subdirector = this.s.findAll();
		List<Administrador> administrador = this.a.findAll();
//		List<Covid2> cov= this.a.findAll();
		
		List<Persona> personaAdmin = new ArrayList<Persona>();
		List<Persona> personaSub = new ArrayList<Persona>();
		List<Persona> personaDir = new ArrayList<Persona>();
		
		
		for (int i = 0; i < administrador.size(); i++) {
			Persona2 p2 = new Persona2();//admin
			for (int j = 0; j < persona.size(); j++) {
				if (administrador.get(i).getPersona() == persona.get(j).getCodigo()) {
					p2 = persona.get(j);
					p2.setCodigo(administrador.get(i).getPersona());
				}
			}
			personaAdmin.add(new Persona(p2.getCodigo(), p2.getNombre(), p2.getTitulo(), p2.getProfesion(),p2.getEmail(), p2.getTelefono()));
			personaAdmin.get(i).setCargo("Administrador");

		}
		//=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
		for (int i = 0; i < subdirector.size(); i++) {
			Persona2 p = new Persona2();//director
			for (int j = 0; j < persona.size(); j++) {
				if (director.get(i).getPersona() == persona.get(j).getCodigo()) {
					p = persona.get(j);
					p.setCodigo(administrador.get(i).getPersona());
					break;
				}
			}
					
			personaDir.add(new Persona(p.getCodigo(), p.getNombre(), p.getTitulo(), p.getProfesion(),p.getEmail(), p.getTelefono()));
			personaDir.get(i).setCargo("Director");
		}
		//=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
		for (int i = 0; i < subdirector.size(); i++) {
			Persona2 p3 = new Persona2();//sub
			for (int j = 0; j < persona.size(); j++) {
				if (subdirector.get(i).getPersona() == persona.get(j).getCodigo()) {
					p3 = persona.get(j);
					p3.setCodigo(subdirector.get(i).getPersona());
					break;
				}
			}

			personaSub.add(new Persona(p3.getCodigo(), p3.getNombre(), p3.getTitulo(), p3.getProfesion(),p3.getEmail(), p3.getTelefono()));
			personaSub.get(i).setCargo("Subdirector");
		}
		for (int i = 0; i < personaSub.size(); i++) {
			personal.add(personaDir.get(i));
			personal.add(personaSub.get(i));
			personal.add(personaAdmin.get(i));
		}
		//=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		for (int i = 0; i < h.size(); i++) {
			Hospital2 haux=h.get(i);
			Persona dir =new Persona();
			Persona sub =new Persona();
			Persona adm =new Persona();
			
			for (int j = 0; j < personal.size(); j++) {
				if(haux.getDirector()==personal.get(j).getCodigo()) {
					dir=personal.get(j);
				}
				if(haux.getSubdirector()==personal.get(j).getCodigo()) {
					sub=personal.get(j);
				}
				if(haux.getAdministrador()==personal.get(j).getCodigo()) {
					adm=personal.get(j);
				}
			}
			
			hospitales.add(new Hospital(haux.getId(),haux.getNombre(),haux.getDireccion(),haux.getMunicipio(),haux.getTelefono(),haux.getNoMedicos(),
										haux.getNoEnfermeros(),haux.getNoAmbulacias(),haux.getNoCamillas(),haux.getNoCuartos(),haux.getNoLab(),
										haux.getServicios(),dir,sub,adm,new Covid(6,42,12,32,54,23)));
		}
		
		
		return hospitales;
	}
	
	
	public void setPersonal(Persona p) {
		Persona2 persona = new Persona2(p.getCodigo(),p.getNombre(),p.getTitulo(),p.getProfesion(),p.getEmail(),p.getTelefono());
		this.p.save(persona);
		
	}
	
	public List<Persona> getPersonal(){
		List<Persona> personal = new ArrayList<>();
		
		
		List<Persona2> persona = this.p.findAll();
		List<Director> director = this.d.findAll();
		List<Subdirector> subdirector = this.s.findAll();
		List<Administrador> administrador = this.a.findAll();
		
		List<Persona> personaAdmin = new ArrayList<Persona>();
		List<Persona> personaSub = new ArrayList<Persona>();
		List<Persona> personaDir = new ArrayList<Persona>();
		
		
		for (int i = 0; i < administrador.size(); i++) {
			Persona2 p2 = new Persona2();//admin
			for (int j = 0; j < persona.size(); j++) {
				if (administrador.get(i).getPersona() == persona.get(j).getCodigo()) {
					p2 = persona.get(j);
					break;
				}
			}
			personaAdmin.add(new Persona(p2.getCodigo(), p2.getNombre(), p2.getTitulo(), p2.getProfesion(),p2.getEmail(), p2.getTelefono()));
			personaAdmin.get(i).setCargo("Administrador");

		}
		//=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
		for (int i = 0; i < subdirector.size(); i++) {
			Persona2 p = new Persona2();//director
			for (int j = 0; j < this.p.findAll().size(); j++) {
				if (director.get(i).getPersona() == persona.get(j).getCodigo()) {
					p = persona.get(j);
					break;
				}
			}
					
			personaDir.add(new Persona(p.getCodigo(), p.getNombre(), p.getTitulo(), p.getProfesion(),p.getEmail(), p.getTelefono()));
			personaDir.get(i).setCargo("Director");
		}
		//=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-==-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
		for (int i = 0; i < subdirector.size(); i++) {
			Persona2 p3 = new Persona2();//sub
			for (int j = 0; j < persona.size(); j++) {
				if (subdirector.get(i).getPersona() == persona.get(j).getCodigo()) {
					p3 = persona.get(j);
					break;
				}
			}

			personaSub.add(new Persona(p3.getCodigo(), p3.getNombre(), p3.getTitulo(), p3.getProfesion(),
					p3.getEmail(), p3.getTelefono()));
			personaSub.get(i).setCargo("Subdirector");
		}
		for (int i = 0; i < personaSub.size(); i++) {
			personal.add(personaDir.get(i));
			personal.add(personaSub.get(i));
			personal.add(personaAdmin.get(i));
		}
		
		return personal;
	}
	
	public List<Covid> getRegistrosCovid(){
		List<Covid> covid=new ArrayList<>();
		
		List<Hospital2> hospital=this.h.findAll();
		List<Covid2> covidDB=this.c.findAll();
		
		for (int i = 0; i < covidDB.size(); i++) {
			Covid2 c = covidDB.get(i);
			
			covid.add(new Covid(c.getId(),c.getNegativos(),c.getEstudio(),c.getPositivos(),c.getDefunciones(),c.getRecuperados()));
		}
		
		return covid;
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
