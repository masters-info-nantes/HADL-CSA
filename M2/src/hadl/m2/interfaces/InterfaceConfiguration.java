package hadl.m2.interfaces;

import java.util.ArrayList;
import java.util.List;

import hadl.m2.interfaces.ports.PortConfiguration;

public class InterfaceConfiguration extends Interface {
	private String name;
	private List<PortConfiguration> ports;

	public InterfaceConfiguration() {
		super();
		ports = new ArrayList<PortConfiguration>();
	}

	public void addPort(PortConfiguration port) {
		ports.add(port);
	}

	public void removePort(PortConfiguration port) {
		ports.remove(port);
	}

	public List<PortConfiguration> getPorts() {
		return ports;
	}

	public String getName() {

		return name;
	}
}
