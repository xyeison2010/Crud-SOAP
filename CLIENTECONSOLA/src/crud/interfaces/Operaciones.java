/**
 * Operaciones.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package crud.interfaces;

public interface Operaciones extends java.rmi.Remote {
    public int eliminar(crud.interfaces.Cliente arg0) throws java.rmi.RemoteException;
    public int actualizar(crud.interfaces.Cliente arg0) throws java.rmi.RemoteException;
    public crud.interfaces.Cliente buscar(crud.interfaces.Cliente arg0) throws java.rmi.RemoteException;
    public crud.interfaces.Cliente[] listar() throws java.rmi.RemoteException;
    public int insertar(crud.interfaces.Cliente arg0) throws java.rmi.RemoteException;
}
