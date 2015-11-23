package hadl.m2.interfaces.services;

import hadl.m2.interfaces.ports.PortSimpleFourni;

import java.util.ArrayList;
import java.util.List;

public class ServiceSimpleFourni extends ServiceSimple {
	protected List<PortSimpleFourni> ports;

	public ServiceSimpleFourni() {
		this.ports = new ArrayList<PortSimpleFourni>();
	}

	public void addPorts(PortSimpleFourni pcf) {
		ports.add(pcf);
	}
}
