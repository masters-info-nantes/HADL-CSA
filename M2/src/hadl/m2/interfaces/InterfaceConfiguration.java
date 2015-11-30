package hadl.m2.interfaces;

import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.Port;

public abstract class InterfaceConfiguration extends Interface {
	private String name;
	private List<Port> ports;

	public InterfaceConfiguration() {
		super();
		ports = new ArrayList<Port>();
	}

	public void addPort(Port port) {
		ports.add(port);
	}

	public void removePort(Port port) {
		ports.remove(port);
	}

	public String getName() {

		return name;
	}
}
