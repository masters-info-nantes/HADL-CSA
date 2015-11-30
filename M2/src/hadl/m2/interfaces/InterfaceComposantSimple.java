package hadl.m2.interfaces;

import java.util.ArrayList;
import java.util.List;

import hadl.m2.interfaces.ports.PortSimple;
import hadl.m2.interfaces.services.ServiceSimple;

public class InterfaceComposantSimple extends Interface {

	private String name;
	private List<ServiceSimple> services;
	private List<PortSimple> ports;

	public InterfaceComposantSimple() {
		super();
		services = new ArrayList<ServiceSimple>();
		ports = new ArrayList<PortSimple>();
	}

	public void addService(ServiceSimple service) {
		services.add(service);
	}

	public void removeService(ServiceSimple service) {
		services.remove(service);
	}

	public List<ServiceSimple> getServices() {
		return services;
	}

	public List<PortSimple> getPorts() {
		return ports;
	}

	public String getName() {
		return name;
	}
}
