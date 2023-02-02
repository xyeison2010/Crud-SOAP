package crud.servicio.impl;

import java.util.List;

import javax.jws.WebService;

import crud.conexion.ClienteDAO;
import crud.entidades.Cliente;
import crud.interfaces.Operaciones;

@WebService(endpointInterface="crud.interfaces.Operaciones")
public class ServicioImpl implements Operaciones {
private Operaciones op = new ClienteDAO();
	@Override
	public List<Cliente> listar() {
		// TODO Auto-generated method stub
		return op.listar();
	}

	@Override
	public Cliente buscar(Cliente cliente) {
		// TODO Auto-generated method stub
		return op.buscar(cliente);
	}

	@Override
	public int insertar(Cliente cliente) {
		// TODO Auto-generated method stub
		return op.insertar(cliente);
	}

	@Override
	public int actualizar(Cliente cliente) {
		// TODO Auto-generated method stub
		return op.actualizar(cliente);
	}

	@Override
	public int eliminar(Cliente cliente) {
		// TODO Auto-generated method stub
		return op.eliminar(cliente);
	}


}
