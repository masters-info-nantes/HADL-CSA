package hadl.m2.interfaces.ports;

import java.util.Observable;

public class PortConfiguration extends Observable {
	protected String name;

	public String getName() {
		return name;
	}
}
