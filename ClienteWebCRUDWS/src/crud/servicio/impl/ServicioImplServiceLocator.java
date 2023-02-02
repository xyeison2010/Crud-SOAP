/**
 * ServicioImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package crud.servicio.impl;

public class ServicioImplServiceLocator extends org.apache.axis.client.Service implements crud.servicio.impl.ServicioImplService {

    public ServicioImplServiceLocator() {
    }


    public ServicioImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ServicioImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ServicioImplPort
    private java.lang.String ServicioImplPort_address = "http://localhost:2021/WS/Servicio";

    public java.lang.String getServicioImplPortAddress() {
        return ServicioImplPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ServicioImplPortWSDDServiceName = "ServicioImplPort";

    public java.lang.String getServicioImplPortWSDDServiceName() {
        return ServicioImplPortWSDDServiceName;
    }

    public void setServicioImplPortWSDDServiceName(java.lang.String name) {
        ServicioImplPortWSDDServiceName = name;
    }

    public crud.interfaces.Operaciones getServicioImplPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ServicioImplPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getServicioImplPort(endpoint);
    }

    public crud.interfaces.Operaciones getServicioImplPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            crud.servicio.impl.ServicioImplPortBindingStub _stub = new crud.servicio.impl.ServicioImplPortBindingStub(portAddress, this);
            _stub.setPortName(getServicioImplPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setServicioImplPortEndpointAddress(java.lang.String address) {
        ServicioImplPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (crud.interfaces.Operaciones.class.isAssignableFrom(serviceEndpointInterface)) {
                crud.servicio.impl.ServicioImplPortBindingStub _stub = new crud.servicio.impl.ServicioImplPortBindingStub(new java.net.URL(ServicioImplPort_address), this);
                _stub.setPortName(getServicioImplPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("ServicioImplPort".equals(inputPortName)) {
            return getServicioImplPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://impl.servicio.crud/", "ServicioImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://impl.servicio.crud/", "ServicioImplPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ServicioImplPort".equals(portName)) {
            setServicioImplPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
