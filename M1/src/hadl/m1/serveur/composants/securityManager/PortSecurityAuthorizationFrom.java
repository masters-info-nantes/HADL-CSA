package hadl.m1.serveur.composants.securityManager;

import hadl.m2.interfaces.ports.PortCptConfigRequis;

public class PortSecurityAuthorizationFrom extends PortCptConfigRequis {

	public PortSecurityAuthorizationFrom(String name) {
		super(name);
	}

	public void receiveFromClearanceRequest(Object arg) {
		System.out.print(this.getClass().getSimpleName()+" -> ");
		this.setChanged();
		this.notifyObservers(arg);
	}
}
