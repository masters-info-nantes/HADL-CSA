package hadl.m2.interfaces.services;

import hadl.m2.interfaces.ports.PortCptConfigRequis;

import java.util.ArrayList;
import java.util.List;

public class ServiceCptConfigRequis extends ServiceCptConfig {

	protected List<PortCptConfigRequis> ports;


	public ServiceCptConfigRequis(String name) {
		this.name = name;
        this.ports = new ArrayList<PortCptConfigRequis>();
	}

	public void addPorts(PortCptConfigRequis pcr) {
		ports.add(pcr);

	}

	public PortCptConfigRequis getPort(String portName) {
		for (PortCptConfigRequis pcr : this.ports) {
			if (pcr.getName().toLowerCase().equals(portName.toLowerCase())) {
				return pcr;
			}
		}
		return null;

	}
}
