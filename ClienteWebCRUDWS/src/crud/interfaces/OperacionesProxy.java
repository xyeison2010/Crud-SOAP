package crud.interfaces;

public class OperacionesProxy implements crud.interfaces.Operaciones {
  private String _endpoint = null;
  private crud.interfaces.Operaciones operaciones = null;
  
  public OperacionesProxy() {
    _initOperacionesProxy();
  }
  
  public OperacionesProxy(String endpoint) {
    _endpoint = endpoint;
    _initOperacionesProxy();
  }
  
  private void _initOperacionesProxy() {
    try {
      operaciones = (new crud.servicio.impl.ServicioImplServiceLocator()).getServicioImplPort();
      if (operaciones != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)operaciones)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)operaciones)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (operaciones != null)
      ((javax.xml.rpc.Stub)operaciones)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public crud.interfaces.Operaciones getOperaciones() {
    if (operaciones == null)
      _initOperacionesProxy();
    return operaciones;
  }
  
  public int insertar(crud.interfaces.Cliente arg0) throws java.rmi.RemoteException{
    if (operaciones == null)
      _initOperacionesProxy();
    return operaciones.insertar(arg0);
  }
  
  public crud.interfaces.Cliente[] listar() throws java.rmi.RemoteException{
    if (operaciones == null)
      _initOperacionesProxy();
    return operaciones.listar();
  }
  
  public int eliminar(crud.interfaces.Cliente arg0) throws java.rmi.RemoteException{
    if (operaciones == null)
      _initOperacionesProxy();
    return operaciones.eliminar(arg0);
  }
  
  public int actualizar(crud.interfaces.Cliente arg0) throws java.rmi.RemoteException{
    if (operaciones == null)
      _initOperacionesProxy();
    return operaciones.actualizar(arg0);
  }
  
  public crud.interfaces.Cliente buscar(crud.interfaces.Cliente arg0) throws java.rmi.RemoteException{
    if (operaciones == null)
      _initOperacionesProxy();
    return operaciones.buscar(arg0);
  }
  
  
}