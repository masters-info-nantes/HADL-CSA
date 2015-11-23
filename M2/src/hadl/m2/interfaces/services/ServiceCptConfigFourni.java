package hadl.m2.interfaces.services;

import hadl.m2.interfaces.ports.PortCptConfigFourni;

import java.util.ArrayList;
import java.util.List;

public class ServiceCptConfigFourni extends ServiceCptConfig {
	protected List<PortCptConfigFourni> ports;

	public ServiceCptConfigFourni() {
		this.ports = new ArrayList<PortCptConfigFourni>();
	}

	public ServiceCptConfigFourni(String name) {
		this.name = name;
	}

	public void addPort(PortCptConfigFourni pcf) {
		ports.add(pcf);
	}

	protected PortCptConfigFourni getPort(String portname) {
		for (PortCptConfigFourni portconf : ports) {
			if (portconf.getName().toLowerCase().equals(portname.toLowerCase())) {
				return portconf;
			}
		}

		return null;
	}
}