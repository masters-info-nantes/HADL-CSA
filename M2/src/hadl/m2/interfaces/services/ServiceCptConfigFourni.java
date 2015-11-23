package hadl.m2.interfaces.services;

import java.util.List;

import hadl.m2.interfaces.ports.PortConfigFourni;

public class ServiceCptConfigFourni extends ServiceCptConfig {
	private List<PortConfigFourni> ports;

	public void addPorts(PortConfigFourni pcf) {
		ports.add(pcf);
	}
}