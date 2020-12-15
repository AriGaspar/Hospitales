package com.springboot.form.app.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
										11,
										4538,
										653,
										1);
		
		this.h.save(hospita);
	}

	public Integer getDirectivosOCovidIDs(String que,Integer hid) {
		List<Hospital2> h2 = this.h.findAll();
		List<Persona2> p2 = this.p.findAll();
		List<Director> d = this.d.findAll();
		List<Subdirector> s = this.s.findAll();
		List<Administrador> a = this.a.findAll();
		
		for (int i = 0; i <d.size() ; i++) {
			if(hid==d.get(i).getId()) {
				
			}
		}
		
		return 1;
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
	
	public void setNewHospital(Hospital h) {
		_hospitales.add(h);
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
	

	private void metodonofuncional() {
		System.out.println(p.findAll().get(0).getNombre());

		List<Hospital> hospitales = Arrays.asList(
				
	
				new Hospital(1, "Hospital Santa Maria", "Calle 3","Solidaridad","9871243219",5,9,4,2,1,2, "Pediatria-Odontologuia-Cardiologuia-Pedos2-Pedaturbia", 
						new Persona(1,"Pedro May","Administración de Empresas","Medico","pedro@gmail.com","9831235432"),
						new Persona(23,"Tendor Yam","Química de Empresas","Medico","tendor@gmail.com","9831235432"),
						new Persona(14,"Eduardo May","Administración de Empresas","Medico","eduardo@gmail.com","9831235432"),
						new Covid(45,42,12,32,54,23)),
				new Hospital(1, "Hospital Santa Maria", "Calle 3","Solidaridad","9871243219",5,9,4,2,1,2, "Pediatria-Caca-Caca2-Pedos2-Pedaturbia", 
						new Persona(1,"Pedro May","Administración de Empresas","Medico","pedro@gmail.com","9831235432"),
						new Persona(23,"Tendor Yam","Química de Empresas","Medico","tendor@gmail.com","9831235432"),
						new Persona(14,"Eduardo May","Administración de Empresas","Medico","eduardo@gmail.com","9831235432"),
						new Covid(45,42,12,32,54,23)),
				new Hospital(2, "Hospital Zaragoza", "Calle 31","Merida","9421543219",1,1,4,2,1,4, "Pediatria-Caca-Caca2-Pedos2-Pedaturbia", 
						new Persona(21,"Albert May","Administración de Empresas","Medico","albert@gmail.com","9831235432"),
						new Persona(12,"Mario May","Química de Empresas","Medico","mario@gmail.com","9831235432"),
						new Persona(4,"MArcos May","Administración de Empresas","Medico","marcos@gmail.com","9831235432"),
						new Covid(1,42,12,32,54,23)),
				new Hospital(3, "Hospital CAKITO", "Calle 45","Chetumal","9876573119",9,4,4,2,1,1, "Pediatria-Caca-Caca2-Pedos2-Pedaturbia", 
						new Persona(55,"Kiko May","Administración de Empresas","Medico","marcos@gmail.com","9831235432"),
						new Persona(323,"Manuel Tamay","Química","Medico","marcos@gmail.com","9831235432"),
						new Persona(31,"Carlos May","Química","Medico","pedro@gmail.com","9831235432"),
						new Covid(3,42,12,32,54,23)),
				new Hospital(4, "Hospital Mendez", "Calle 65","Carrillo York","9276543246",4,1,4,2,1,1, "Pediatria-Caca-Caca2-Pedos2-Pedaturbia", 
						new Persona(432,"Marquitos Mendez","Química","Medico","marcos@gmail.com","9831235432"),
						new Persona(42,"Juan Marquez","Química","Medico","marcos@gmail.com","9831235432"),
						new Persona(46,"Jose Tun","Química","Medico","pedro@gmail.com","9831235432"),
						new Covid(6,42,12,32,54,23))
				); 
		
		for (int i = 0; i < hospitales.size(); i++) {
			hospitales.get(i).get_covid().setDeHospital(hospitales.get(i).getNombre());
			
			hospitales.get(i).get_director().setDeHospital(hospitales.get(i).getNombre());
			hospitales.get(i).get_director().setCargo("Director");
			
			hospitales.get(i).get_subdirector().setDeHospital(hospitales.get(i).getNombre());
			hospitales.get(i).get_subdirector().setCargo("Subdirector");
			
			hospitales.get(i).get_administrador().setDeHospital(hospitales.get(i).getNombre());
			hospitales.get(i).get_administrador().setCargo("Administrador");
		}//
	}
}
