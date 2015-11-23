package hadl.m2.interfaces.services;

import hadl.m2.interfaces.ports.PortCptConfigFourni;

import java.util.List;

public class ServiceCptConfigFourni extends ServiceCptConfig {
	private List<PortCptConfigFourni> ports;

	public ServiceCptConfigFourni(String name) {
		this.name = name;
	}

	public void addPorts(PortCptConfigFourni pcf) {
		ports.add(pcf);
	}

	protected PortCptConfigFourni getPort(String portName) {
		for (PortCptConfigFourni pccf : ports) {
			if (pccf.getName().toLowerCase().equals(portName.toLowerCase())) {
				return pccf;
			}
		}
		return null;
	}
}