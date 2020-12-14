package com.springboot.form.app;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.springboot.form.app.models.Administrador;
import com.springboot.form.app.models.Covid;
import com.springboot.form.app.models.Covid2;
import com.springboot.form.app.models.Director;
import com.springboot.form.app.models.Hospital;
import com.springboot.form.app.models.Hospital2;
import com.springboot.form.app.models.Persona;
import com.springboot.form.app.models.Persona2;
import com.springboot.form.app.models.Subdirector;

public class ConsultaHospitales {

	
	
	public static void main(String[] args) {
		// Hospital
		SessionFactory miHospital = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Hospital2.class).buildSessionFactory();
		Session miSessionHospital = miHospital.openSession();

		// Director
		SessionFactory miDirector = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Director.class).buildSessionFactory();
		Session miSessionDirector = miDirector.openSession();

		// Administrador
		SessionFactory miAdministrador = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Administrador.class).buildSessionFactory();
		Session miSessionAdministrador = miAdministrador.openSession();

		// Subdirector
		SessionFactory miSubdirector = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Subdirector.class).buildSessionFactory();
		Session miSessionSubdirector = miSubdirector.openSession();

		// Covid
		SessionFactory miCovid = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Covid2.class).buildSessionFactory();
		Session miSessionCovid = miCovid.openSession();

		// Persona
		SessionFactory miPersona = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Persona2.class).buildSessionFactory();
		Session miSessionPersona = miPersona.openSession();

		try {
			// Hospital=========================================
			miSessionHospital.beginTransaction();
			List<Hospital2> listHospital = miSessionHospital.createQuery("from Hospital2").getResultList();
//			System.out.println("nombre: "+listHospital.get(0).getNombre());
//			for (Hospital2 h: listHospital) {
//				System.out.println(h.getMunicipio());
//			}
			// Covid=========================================
			miSessionCovid.beginTransaction();
				List<Covid2> listCovid = miSessionCovid.createQuery("from Covid2").getResultList();
				List<Covid> covid = new ArrayList<Covid>();
				System.out.println("============Que onda: "+listCovid.get(0).getNegativos());
				for (int i = 0; i < listCovid.size(); i++) {
					Covid2 c = listCovid.get(i);
					covid.add(new Covid(c.getId(),c.getNegativos(),c.getEstudio(),c.getPositivos(),c.getDefunciones(),c.getRecuperados()));
				}
				
				
			// Persona==========================================
			miSessionPersona.beginTransaction();
				@SuppressWarnings("unchecked")
				List<Persona2> listPersona = miSessionPersona.createQuery("from Persona2").getResultList();
//				for (Persona2 persona : listPersona) {
//					System.out.println(persona.getNombre());
//				}
			// Subdirector=========================================
			miSessionSubdirector.beginTransaction();

				List<Subdirector> listSubdirector = miSessionSubdirector.createQuery("from Subdirector").getResultList();
				List<Persona> personaSub = new ArrayList<Persona>();
	
				for (int i = 0; i < listSubdirector.size(); i++) {
	
					Persona2 p = new Persona2();
	
					for (int j = 0; j < listPersona.size(); j++) {
						if (listSubdirector.get(i).getPersona() == listPersona.get(j).getCodigo()) {
							p = listPersona.get(j);
							p.setCodigo(listSubdirector.get(i).getId());
							break;
						}
					}
	
					personaSub.add(new Persona(p.getCodigo(), p.getNombre(), p.getTitulo(), p.getProfesion(), p.getEmail(),
							p.getTelefono()));
				}
				
				
			// Director=========================================
			miSessionDirector.beginTransaction();
				List<Director> listDirector = miSessionDirector.createQuery("from Director").getResultList();
				List<Persona> personaDir = new ArrayList<Persona>();
	
				for (int i = 0; i < listDirector.size(); i++) {
	
					Persona2 p = new Persona2();
	
					for (int j = 0; j < listPersona.size(); j++) {
						if (listDirector.get(i).getPersona() == listPersona.get(j).getCodigo()) {
							p = listPersona.get(j);
							p.setCodigo(listDirector.get(i).getId());
							break;
						}
					}
	
					personaDir.add(new Persona(p.getCodigo(), p.getNombre(), p.getTitulo(), p.getProfesion(), p.getEmail(),
							p.getTelefono()));
				}
				

			// Administrador================================
			miSessionAdministrador.beginTransaction();
				List<Administrador> listAdministrador = miSessionAdministrador.createQuery("from Administrador").getResultList();
				List<Persona> personaAdmin = new ArrayList<Persona>();
	
				for (int i = 0; i < listAdministrador.size(); i++) {
	
					Persona2 p = new Persona2();
	
					for (int j = 0; j < listPersona.size(); j++) {
						if (listAdministrador.get(i).getPersona() == listPersona.get(j).getCodigo()) {
							p = listPersona.get(j);
							p.setCodigo(listAdministrador.get(i).getId());
							break;
						}
					}
	
					personaAdmin.add(new Persona(p.getCodigo(), p.getNombre(), p.getTitulo(), p.getProfesion(),
							p.getEmail(), p.getTelefono()));
				}
				
			
				
			List<Hospital> hospitales=new ArrayList<>();
				for (int i = 0; i < listHospital.size(); i++) {
					Hospital2 haux=listHospital.get(i);
					Persona dir =new Persona();
					Persona sub =new Persona();
					Persona adm =new Persona();
					
					for (int j = 0; j < personaDir.size(); j++) {
						if(haux.getDirector()==personaDir.get(j).getCodigo()) {
							dir=personaDir.get(j);
							break;
						}
					}
					for (int j = 0; j < personaSub.size(); j++) {
						if(haux.getSubdirector()==personaSub.get(j).getCodigo()) {
							sub=personaSub.get(j);
							break;
						}
					}
					for (int j = 0; j < personaAdmin.size(); j++) {
						if(haux.getAdministrador()==personaAdmin.get(j).getCodigo()) {
							adm=personaAdmin.get(j);
							break;
						}
					}
					hospitales.add(new Hospital(haux.getId(),haux.getNombre(),haux.getDireccion(),haux.getMunicipio(),haux.getTelefono(),haux.getNoMedicos(),
												haux.getNoEnfermeros(),haux.getNoAmbulacias(),haux.getNoCamillas(),haux.getNoCuartos(),haux.getNoLab(),
												haux.getServicios(),dir,sub,adm,new Covid(6,42,12,32,54,23)));
				}
			for (Hospital hospital : hospitales) {
				hospital.toString();
			}
		} finally {

			miAdministrador.close();
			miDirector.close();
			miHospital.close();
			miPersona.close();
			miCovid.close();
			miSubdirector.close();

		}

	}

}
