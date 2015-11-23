package hadl.m2.interfaces.services;

import hadl.m2.interfaces.ports.PortSimpleFourni;

import java.util.List;

public class ServiceSimpleFourni extends ServiceSimple {
	private List<PortSimpleFourni> ports;

	public void addPorts(PortSimpleFourni pcf) {
		ports.add(pcf);
	}
}
