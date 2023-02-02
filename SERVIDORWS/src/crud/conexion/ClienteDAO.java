package crud.conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import crud.entidades.Cliente;
import crud.interfaces.Operaciones;

public class ClienteDAO implements Operaciones {
	private Conexion conexion = new Conexion();

	// Constantes SQL
	private static final String SQL_SELECT = "SELECT id_cliente, nombre,apellido,email,telefono,saldo FROM cliente";
	private static final String SQL_SELECT_BY_ID = "SELECT id_cliente, nombre,apellido,email,telefono,saldo FROM cliente WHERE id_cliente=?";
	private static final String SQL_INSERT = "INSERT INTO cliente(nombre,apellido,email,telefono,saldo) VALUES(?,?,?,?,?)";
	private static final String SQL_UPDATE = "UPDATE cliente SET nombre=?, apellido=?, email=?, telefono=?, saldo=? WHERE id_cliente=?";
	private static final String SQL_DELETE = "DELETE FROM cliente WHERE id_cliente=?";

	@Override
	public List<Cliente> listar() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Cliente> clientes = new ArrayList<Cliente>();
		try {
			conn = conexion.getConnection();
			stmt = conn.prepareStatement(SQL_SELECT);
			rs = stmt.executeQuery();
			while (rs.next()) {
				int idCliente = rs.getInt("id_cliente");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String email = rs.getString("email");
				String telefono = rs.getString("telefono");
				double saldo = rs.getDouble("saldo");
				System.out.println(nombre + " " + apellido + ",  " + email);
				clientes.add(new Cliente(idCliente, nombre, apellido, email, telefono, saldo));

			}

		} catch (Exception e) {
			e.printStackTrace(System.out);
		} finally {
			Conexion.Close(conn);
			Conexion.Close(stmt);
			Conexion.Close(rs);
		}
		return clientes;
	}

	@Override
	public Cliente buscar(Cliente cliente) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = conexion.getConnection();
			stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
			stmt.setInt(1, cliente.getIdCliente());
			rs = stmt.executeQuery();
			rs.next();

			String nombre = rs.getString("nombre");
			String apellido = rs.getString("apellido");
			String email = rs.getString("email");
			String telefono = rs.getString("telefono");
			double saldo = rs.getDouble("saldo");
			
			cliente.setNombre(nombre);
			cliente.setApellido(apellido);
			cliente.setEmail(email);
			cliente.setTelefono(telefono);
			cliente.setSaldo(saldo);

		} catch (Exception e) {
			e.printStackTrace(System.out);
		} finally {
			Conexion.Close(conn);
			Conexion.Close(stmt);
			Conexion.Close(rs);
		}
		return cliente;
	}

	@Override
	public int insertar(Cliente cliente) {
		Connection conn = null;
		PreparedStatement stmt = null;
		int rows=0;
		try {
			conn = conexion.getConnection();
			stmt = conn.prepareStatement(SQL_INSERT);
			stmt.setString(1, cliente.getNombre());
			stmt.setString(2, cliente.getApellido());
			stmt.setString(3, cliente.getEmail());
			stmt.setString(4, cliente.getTelefono());
			stmt.setDouble(5, cliente.getSaldo());
			rows=stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace(System.out);
		} finally {
			Conexion.Close(conn);
			Conexion.Close(stmt);
		}
		return rows;
	}

	@Override
	public int actualizar(Cliente cliente) {
		Connection conn = null;
		PreparedStatement stmt = null;
		int rows=0;
		try {
			conn = conexion.getConnection();
			stmt = conn.prepareStatement(SQL_UPDATE);
			stmt.setString(1, cliente.getNombre());
			stmt.setString(2, cliente.getApellido());
			stmt.setString(3, cliente.getEmail());
			stmt.setString(4, cliente.getTelefono());
			stmt.setDouble(5, cliente.getSaldo());
			stmt.setInt(6, cliente.getIdCliente());
			rows=stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace(System.out);
		} finally {
			Conexion.Close(conn);
			Conexion.Close(stmt);
		}
		return rows;
	}
	

	@Override
	public int eliminar(Cliente cliente) {
		Connection conn = null;
		PreparedStatement stmt = null;
		int rows=0;
		try {
			conn = conexion.getConnection();
			stmt = conn.prepareStatement(SQL_DELETE);
			stmt.setInt(1, cliente.getIdCliente());
			rows=stmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace(System.out);
		} finally {
			Conexion.Close(conn);
			Conexion.Close(stmt);
		}
		return rows;
	}
	
	public static void main(String[] args) {
		ClienteDAO dao = new ClienteDAO();
		dao.listar();
	}

}
