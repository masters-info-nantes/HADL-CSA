package hadl.m2.interfaces;

import hadl.m2.interfaces.ports.PortCptConfig;
import hadl.m2.interfaces.services.ServiceCptConfig;

import java.util.ArrayList;
import java.util.List;

public class InterfaceComposantConfig extends Interface {
	private String name;
	private List<ServiceCptConfig> services;
	private List<PortCptConfig> ports;

	public InterfaceComposantConfig() {
		super();
		services = new ArrayList<ServiceCptConfig>();
		ports = new ArrayList<PortCptConfig>();
	}

	public void addService(ServiceCptConfig service) {
		services.add(service);
	}

	public void removeService(ServiceCptConfig service) {
		services.remove(service);
	}

	public List<ServiceCptConfig> getServices() {

        return services;
	}

	public List<PortCptConfig> getPorts() {
		return ports;
	}

    public PortCptConfig getPort(String name){
        for (PortCptConfig port : this.ports) {
            if(port.getName().toLowerCase().equals(name.toLowerCase())) {
                return port;
            }

        }
        return null;
    }

	public String getName() {

		return name;
	}

    public ServiceCptConfig getService(String serviceName) {
        for (ServiceCptConfig service : services) {
            if(service.getName().toLowerCase().equals(serviceName.toLowerCase())){
                return service;
            }
        }
        return null;
    }
}
