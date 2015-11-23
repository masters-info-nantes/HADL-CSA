package hadl.m2.interfaces.services;

import hadl.m2.interfaces.ports.PortConfigRequis;

import java.util.List;

public class ServiceCptConfigRequis extends ServiceCptConfig {

	private List<PortConfigRequis> ports;

	public ServiceCptConfigRequis(String name) {
		this.name = name;
	}

	public void addPorts(PortConfigRequis pcr) {
		ports.add(pcr);
	}
}
