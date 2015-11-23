package hadl.m2.interfaces.services;

import hadl.m2.interfaces.ports.PortSimpleRequis;

import java.util.List;

public class ServiceSimpleRequis extends ServiceSimple {
	private List<PortSimpleRequis> ports;

	public void addPorts(PortSimpleRequis pcf) {
		ports.add(pcf);
	}
}
