package alma.m2.interfaces.services;

import java.util.List;

import alma.m2.interfaces.ports.PortSimpleFourni;

public class ServiceSimpleFourni extends ServiceSimple {
	private List<PortSimpleFourni> ports;

	public void addPorts(PortSimpleFourni pcf) {
		ports.add(pcf);
	}
}
