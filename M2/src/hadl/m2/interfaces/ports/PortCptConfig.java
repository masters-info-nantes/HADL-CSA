package hadl.m2.interfaces.ports;

import java.util.Observable;

public abstract class PortCptConfig extends Observable {
	protected String name;

	public String getName() {
		return name;
	}
}
