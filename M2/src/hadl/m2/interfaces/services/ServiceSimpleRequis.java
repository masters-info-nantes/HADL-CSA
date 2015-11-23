package hadl.m2.interfaces.services;

import hadl.m2.interfaces.ports.PortSimpleRequis;

import java.util.ArrayList;
import java.util.List;

public class ServiceSimpleRequis extends ServiceSimple {
	protected List<PortSimpleRequis> ports;

	public ServiceSimpleRequis() {
		this.ports = new ArrayList<PortSimpleRequis>();
	}

	public void addPorts(PortSimpleRequis pcf) {
		ports.add(pcf);
	}
}
