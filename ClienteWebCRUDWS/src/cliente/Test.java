package cliente;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import crud.interfaces.Cliente;
import crud.interfaces.Operaciones;
import crud.servicio.impl.ServicioImplPortBindingStub;
import crud.servicio.impl.ServicioImplService;
import crud.servicio.impl.ServicioImplServiceLocator;

public class Test {

	public Cliente[] getServicioListar() throws MalformedURLException, RemoteException {
		ServicioImplService servicio = new ServicioImplServiceLocator();
		Operaciones ws = new ServicioImplPortBindingStub(new URL(servicio.getServicioImplPortAddress()),servicio);
		return ws.listar();

	}

	public Cliente getServicioBuscar(Cliente cliente) throws MalformedURLException, RemoteException {
		ServicioImplService servicio = new ServicioImplServiceLocator();
		Operaciones ws = new ServicioImplPortBindingStub(new URL(servicio.getServicioImplPortAddress()),servicio);
		return ws.buscar(cliente);
	}
	
	public int getServicioInsertar(Cliente cliente) throws MalformedURLException, RemoteException {
		ServicioImplService servicio = new ServicioImplServiceLocator();
		Operaciones ws = new ServicioImplPortBindingStub(new URL(servicio.getServicioImplPortAddress()),servicio);
		return ws.insertar(cliente);
	}
	
	public int getServicioActualizar(Cliente cliente) throws MalformedURLException, RemoteException {
		ServicioImplService servicio = new ServicioImplServiceLocator();
		Operaciones ws = new ServicioImplPortBindingStub(new URL(servicio.getServicioImplPortAddress()),servicio);
		return ws.actualizar(cliente);
	}
	
	public int getServicioEliminar(Cliente cliente) throws MalformedURLException, RemoteException {
		ServicioImplService servicio = new ServicioImplServiceLocator();
		Operaciones ws = new ServicioImplPortBindingStub(new URL(servicio.getServicioImplPortAddress()),servicio);
		return ws.eliminar(cliente);
	}
}
