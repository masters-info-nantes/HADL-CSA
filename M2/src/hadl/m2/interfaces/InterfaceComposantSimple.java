package hadl.m2.interfaces;

import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.Port;

import hadl.m2.interfaces.services.ServiceSimple;

public class InterfaceComposantSimple extends Interface {

	private String name;
	private List<ServiceSimple> services;
	private List<Port> ports;

	public InterfaceComposantSimple() {
		super();
		services = new ArrayList<ServiceSimple>();
		ports = new ArrayList<Port>();
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

	public String getName() {
		return name;
	}
}
