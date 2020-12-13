package com.springboot.form.app;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.springboot.form.app.models.Administrador;
import com.springboot.form.app.models.Covid2;
import com.springboot.form.app.models.Director;
import com.springboot.form.app.models.Hospital2;
import com.springboot.form.app.models.Persona2;
import com.springboot.form.app.models.Subdirector;

public class ConsultaHospitales {

	public static void main(String[] args) {
		// Hospital
		SessionFactory miHosptal=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Hospital2.class).buildSessionFactory();
		Session miSessionHospital=miHosptal.openSession();
		
		// Director
		SessionFactory miDirector=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Director.class).buildSessionFactory();
		Session miSessionDirector=miDirector.openSession();
		
		// Administrador
		SessionFactory miAdministrador=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Administrador.class).buildSessionFactory();
		Session miSessionAdministrador=miAdministrador.openSession();
		
		// Subdirector
		SessionFactory miSubdirector=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Subdirector.class).buildSessionFactory();
		Session miSessionSubdirector=miSubdirector.openSession();
				
		// Covid
		SessionFactory miCovid=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Covid2.class).buildSessionFactory();
		Session miSessionCovid=miCovid.openSession();
		
		// Persona
		SessionFactory miPersona=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Persona2.class).buildSessionFactory();
		Session miSessionPersona=miPersona.openSession();
		
		try {
			// Hospital
				// Comenzar Sesión
				miSessionHospital.beginTransaction();
				// Consulat de Hospitales
				List<Hospital2> listHospital=miSessionHospital.createQuery("from Hospital2").getResultList();
				
			// Covid
				// Comenzar Sesión
				miSessionCovid.beginTransaction();
				// Consulat de Hospitales
				List<Covid2> listCovid=miSessionCovid.createQuery("from Covid2").getResultList();
				
			// Subdirector
				// Comenzar Sesión
				miSessionSubdirector.beginTransaction();
				// Consulat de Hospitales
				List<Subdirector> listSubdirector=miSessionSubdirector.createQuery("from Subdirector").getResultList();
			
			// Persona
				// Comenzar Sesión
				miSessionPersona.beginTransaction();
				// Consulat de Persona
				List<Persona2> listPersona=miSessionPersona.createQuery("from Persona2").getResultList();
			
			// Director
				// Comenzar Sesión
				miSessionDirector.beginTransaction();
				// Consulat de Hospitales
				List<Director> listDirector=miSessionDirector.createQuery("from Director").getResultList();
				
			// Administrador
				// Comenzar Sesión
				miSessionAdministrador.beginTransaction();
				// Consulta de Administrador
				List<Administrador> listAdministrador=miSessionAdministrador.createQuery("from Administrador").getResultList();
				
			
				// Buscardor Director
				for (Hospital2 unHospital:listHospital) {
					for (Director d:listDirector) {
						for (Persona2 p:listPersona) {
							if (unHospital.getDirector()==d.getId()) {
								System.out.println(d);
								if (d.getPersona()==p.getCodigo()) {
									System.out.println(p);
								}
							}
						}
						
					}
					System.out.println("--------------------------------------------");
				}
				
				System.out.println("****************************************************************");
				
				// Buscardor Adminsitrador
				for (Hospital2 unHospital:listHospital) {
					for (Administrador a:listAdministrador) {
						for (Persona2 p:listPersona) {
							if (unHospital.getAdministrador()==a.getId()) {
								System.out.println(a);
								if (a.getPersona()==p.getCodigo()) {
									System.out.println(p);
								}
							}
						}
						
					}
					System.out.println("--------------------------------------------");
				}
				
				System.out.println("****************************************************************");
				
				// Buscardor Covid
				for (Hospital2 unHospital:listHospital) {
					for (Subdirector s:listSubdirector) {
						for (Persona2 p:listPersona) {
							if (unHospital.getSubdirector()==s.getId()) {
								System.out.println(s);
								if (s.getPersona()==p.getCodigo()) {
									System.out.println(p);
								}
							}
						}
						
					}
					System.out.println("--------------------------------------------");
				}
			
		} finally {
			
			miAdministrador.close();
			miDirector.close();
			miHosptal.close();
			miPersona.close();
			miCovid.close();
			miSubdirector.close();
			
		}

	}

}
