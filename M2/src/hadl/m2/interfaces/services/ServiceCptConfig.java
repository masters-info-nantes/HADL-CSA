package hadl.m2.interfaces.services;

import java.util.Observable;

public abstract class ServiceCptConfig extends Observable {
	protected String name;

	public String getName() {
		return name;
	}

}
