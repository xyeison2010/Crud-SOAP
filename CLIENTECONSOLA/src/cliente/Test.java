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

//	public static void main(String[] args)throws MalformedURLException, RemoteException {
//		ServicioImplService servicio = new ServicioImplServiceLocator();
//		Operaciones ws = new ServicioImplPortBindingStub(new URL(servicio.getServicioImplPortAddress()),servicio);
//		System.out.println("Lista de Clientes");
//		System.out.println("---------------------------------");
//		
//		for (Cliente cliente : ws.listar()) {
//			System.out.println(cliente.getNombre()+" "+cliente.getApellido()+", "+cliente.getSaldo());
//		}
//
//	}

	static double solution(int[][] p) {
		double minimal = 0;
		for (int i = 0; i < p.length; i++) {

			for (int j = 0; j < p[0].length; j++) {

				minimal = Math
						.sqrt((p[0][0] - p[1][0]) * (p[0][1] - p[1][1]) + (p[0][0] - p[0][1]) * (p[1][0] - p[1][1]));

			}

		}
		
		System.out.println("Hola Juan");
		return minimal;

	}

	public static void main(String[] args) {
	int[][]	p = { {0, 11}, {-7, 1}, {-5, -3}};
	
	System.out.println(""+solution(p));
	}

}
