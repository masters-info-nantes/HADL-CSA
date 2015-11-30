package hadl.m1.serveur.composants.securityManager;

import hadl.m2.interfaces.ports.PortCptConfigRequis;

public class PortSecurityAuthorizationFrom extends PortCptConfigRequis {

	public PortSecurityAuthorizationFrom(String name) {
		super(name);
	}

	public void sendToSecurityManager(Object arg) {
		this.setChanged();
		this.notifyObservers(arg);
	}
}
