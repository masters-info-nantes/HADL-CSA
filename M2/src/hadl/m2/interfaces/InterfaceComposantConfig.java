package hadl.m2.interfaces;

import java.util.ArrayList;
import java.util.List;

import hadl.m2.interfaces.ports.PortCptConfig;
import hadl.m2.interfaces.services.ServiceCptConfig;

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

	public String getName() {

		return name;
	}
}
