package com.grupo3.digitalbook.demo.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConexionBaseDeDatos {

    private Connection conexion;
    private Statement consultas;
    private ResultSet resultado;

    // jdbc:mysql://localhost:3306/?user=root
    // root@localhost:3306

    public ConexionBaseDeDatos() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Driver de la base de datos
            // Modificar la ruta de debajo dependiendo de cada computadora
            conexion = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");
            consultas = conexion.createStatement();
            System.out.println("Conexión exitosa");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }



}
