package hadl.m1.serveur.composants.connectionManager;

import hadl.m2.interfaces.ports.PortCptConfigRequis;

public class PortExternalSocketFrom extends PortCptConfigRequis {

	public PortExternalSocketFrom(String name) {
		super(name);
	}

	public void sendRequest(Object arg) {
			this.setChanged();
			this.notifyObservers(arg);
	}
}
