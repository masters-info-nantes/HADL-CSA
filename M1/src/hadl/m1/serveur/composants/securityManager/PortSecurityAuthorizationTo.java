package hadl.m1.serveur.composants.securityManager;

import hadl.m2.interfaces.ports.PortCptConfigFourni;

public class PortSecurityAuthorizationTo extends PortCptConfigFourni {

	public PortSecurityAuthorizationTo(String name) {
		super(name);
	}

	public void sendToClearanceRequest(Object arg) {
		System.out.print(this.getClass().getSimpleName()+" -> ");
    	this.setChanged();
    	this.notifyObservers(arg);
    }
}
