package alma.m2.interfaces.services;

import java.util.List;

import alma.m2.interfaces.ports.PortConfigRequis;

public class ServiceCptConfigRequis extends ServiceCptConfig {

	private List<PortConfigRequis> ports;

	public void addPorts(PortConfigRequis pcr) {
		ports.add(pcr);
	}
}
