package com.springboot.form.app;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HospitalesApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalesApplication.class, args);
		
		String jdbcUrl="jdbc:mysql://localhost:3306/hospital_qr?useSSL=false";
		String usuario="root";
		String contra="";
		
		try {
			System.out.println("Intentando conectar con la BBDD: " + jdbcUrl);
			
			Connection miConexion=DriverManager.getConnection(jdbcUrl, usuario, contra);
			
			System.out.println("Conexión exitosa!!");
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
	}

}
