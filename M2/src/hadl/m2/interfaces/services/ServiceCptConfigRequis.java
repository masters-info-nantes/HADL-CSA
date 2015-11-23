package hadl.m2.interfaces.services;

import hadl.m2.interfaces.ports.PortConfigRequis;

import java.util.ArrayList;
import java.util.List;

public class ServiceCptConfigRequis extends ServiceCptConfig {

	protected List<PortConfigRequis> ports;

	public ServiceCptConfigRequis() {
		this.ports = new ArrayList<PortConfigRequis>();
	}

	public ServiceCptConfigRequis(String name) {
		this.name = name;
	}

	public void addPorts(PortConfigRequis pcr) {
		ports.add(pcr);
	}

	protected PortConfigRequis getInterface(String portName) {
		for (PortConfigRequis pcr : this.ports) {
			if (pcr.getName().toLowerCase().equals(portName.toLowerCase())) {
				return pcr;
			}
		}
		return null;

	}
}
