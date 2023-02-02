package crud.interfaces;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import crud.entidades.Cliente;

@WebService
public interface Operaciones {
	
	@WebMethod
	public List<Cliente> listar();
	
	@WebMethod
	public Cliente buscar(Cliente cliente);
	
	@WebMethod
	public int insertar(Cliente cliente);
	
	@WebMethod
	public int actualizar(Cliente cliente);
	
	@WebMethod
	public int eliminar(Cliente cliente);
	
}
