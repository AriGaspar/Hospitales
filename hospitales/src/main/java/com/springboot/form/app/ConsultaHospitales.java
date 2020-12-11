package com.springboot.form.app;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.springboot.form.app.models.HospitalPrueba;

public class ConsultaHospitales {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory miFactory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(HospitalPrueba.class).buildSessionFactory();
		
		Session miSession=miFactory.openSession();
		
		try {
			
			// Comenzar Sesión
			miSession.beginTransaction();
			// Consulat de Hospitales
			List<HospitalPrueba> listHospitales=miSession.createQuery("FROM HospitalPrueba").getResultList();
			// Mostrar los Hospitales
			for (HospitalPrueba unHospital:listHospitales) {
				System.out.println(unHospital);
			}
			
		} finally {

			miFactory.close();
			
		}

	}

}
