package hadl.m1.client;

import hadl.m2.interfaces.ports.PortCptConfigRequis;

public class PortReceptionReponse extends PortCptConfigRequis {

	public PortReceptionReponse(String name) {
		super(name);

	}

	public void get(Object arg) {

		this.setChanged();
		this.notifyObservers(arg);

	}

}
