package alma.m2.interfaces.services;

import java.util.List;

import alma.m2.interfaces.ports.PortSimpleRequis;

public class ServiceSimpleRequis extends ServiceSimple {
	private List<PortSimpleRequis> ports;

	public void addPorts(PortSimpleRequis pcf) {
		ports.add(pcf);
	}
}
