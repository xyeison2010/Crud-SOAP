package crud.servicio.impl;

import javax.xml.ws.Endpoint;

public class ServicioPublish {

	public static void main(String[] args) {
		Endpoint.publish("http://localhost:2021/WS/Servicio", new ServicioImpl());
		System.out.println("Servidor corriendo...");

	}

}
