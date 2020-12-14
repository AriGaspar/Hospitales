package com.springboot.form.app;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication

public class HospitalesApplication {
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(HospitalesApplication.class, args);
		
//		String jdbcUrl="jdbc:mysql://localhost/hospital_qr?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
//		String usuario="root";
//		String contra="";
//		
//		try {
//			System.out.println("Intentando conectar con la BBDD: " + jdbcUrl);
//			
//			Connection miConexion=DriverManager.getConnection(jdbcUrl, usuario, contra);
//			
//			System.out.println("Conexión exitosa!!");
//		} catch (Exception e) {
//			
//			e.printStackTrace();
//		}
		
		
	}
	
}
