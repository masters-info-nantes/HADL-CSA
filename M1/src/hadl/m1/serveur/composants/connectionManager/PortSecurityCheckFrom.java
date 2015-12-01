package hadl.m1.serveur.composants.connectionManager;

import hadl.m2.interfaces.ports.PortCptConfigRequis;

public class PortSecurityCheckFrom extends PortCptConfigRequis {

	public PortSecurityCheckFrom(String name) {
		super(name);
	}

    public void receiveFromClearanceRequest(Object arg) {

    	this.setChanged();
    	this.notifyObservers(arg);
    }
}
