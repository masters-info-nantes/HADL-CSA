package hadl.m2.interfaces.services;

import hadl.m2.interfaces.ports.PortCptConfigRequis;

import java.util.ArrayList;
import java.util.List;

public class ServiceCptConfigRequis extends ServiceCptConfig {

	protected List<PortCptConfigRequis> ports;

	public ServiceCptConfigRequis() {
		this.ports = new ArrayList<PortCptConfigRequis>();
	}

	public ServiceCptConfigRequis(String name) {
		this.name = name;
	}

	public void addPorts(PortCptConfigRequis pcr) {
		ports.add(pcr);

	}

	protected PortCptConfigRequis getInterface(String portName) {
		for (PortCptConfigRequis pcr : this.ports) {
			if (pcr.getName().toLowerCase().equals(portName.toLowerCase())) {
				return pcr;
			}
		}
		return null;

	}
}
