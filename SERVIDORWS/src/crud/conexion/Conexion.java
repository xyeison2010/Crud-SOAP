package crud.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion {
	// Credenciales
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/control_clientes";
	private static final String JDBC_USER = "root";
	private static final String JDBC_PASSWORD = "root";
	private static final String JDBC_NAME = "com.mysql.cj.jdbc.Driver";

	// Conectarse a la DB
	public Connection getConnection()
	{
		Connection conn = null;
		try {
			Class.forName(JDBC_NAME);
			System.out.println("Conexion a la base OK");
		} catch (Exception e) {
			System.out.println("¡Error al cargar el controlador!");
		}
		try {
			conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
		} catch (SQLException ex) {
			System.out.println("¡Error al conectarse a la base de datos!");

		}
		return conn;

	}
	
	public static void Close(ResultSet rs) {
		try {
			rs.close();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}
	
	public static void Close(PreparedStatement rs) {
		try {
			rs.close();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}
	
	public static void Close(Connection rs) {
		try {
			rs.close();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}
	

}
