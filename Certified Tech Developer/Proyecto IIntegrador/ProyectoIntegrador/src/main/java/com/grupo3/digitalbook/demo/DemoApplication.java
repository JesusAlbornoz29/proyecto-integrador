package com.grupo3.digitalbook.demo;

import com.grupo3.digitalbook.demo.DB.ConexionBaseDeDatos;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		PropertyConfigurator.configure("log4j.properties");
		SpringApplication.run(DemoApplication.class, args);

		ConexionBaseDeDatos cbd = new ConexionBaseDeDatos();

	}

}
