package alma.m2.interfaces.services;

import java.util.List;

import alma.m2.interfaces.ports.PortConfigFourni;

public class ServiceCptConfigFourni extends ServiceCptConfig {
	private List<PortConfigFourni> ports;

	public void addPorts(PortConfigFourni pcf) {
		ports.add(pcf);
	}
}