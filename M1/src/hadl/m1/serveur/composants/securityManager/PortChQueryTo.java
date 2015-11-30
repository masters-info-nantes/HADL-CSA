package hadl.m1.serveur.composants.securityManager;

import hadl.m2.interfaces.ports.PortCptConfigFourni;

public class PortChQueryTo extends PortCptConfigFourni {

	public PortChQueryTo(String name) {
		super(name);
	}

	public void sendToSecurityQuery(Object arg) {
    	this.setChanged();
    	this.notifyObservers(arg);
    }
}
