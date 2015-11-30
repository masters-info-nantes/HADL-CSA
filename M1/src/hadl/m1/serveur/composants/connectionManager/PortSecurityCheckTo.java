package hadl.m1.serveur.composants.connectionManager;

import hadl.m2.interfaces.ports.PortCptConfigFourni;

public class PortSecurityCheckTo extends PortCptConfigFourni {

	public PortSecurityCheckTo(String name) {
		super(name);

	}

	public void sendResponse(Object arg) {
		this.setChanged();
		this.notifyObservers(arg);
	}


}
