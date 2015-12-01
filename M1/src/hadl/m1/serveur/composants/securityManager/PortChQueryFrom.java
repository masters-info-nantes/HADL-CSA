package hadl.m1.serveur.composants.securityManager;

import hadl.m2.interfaces.ports.PortCptConfigRequis;

public class PortChQueryFrom extends PortCptConfigRequis {

	public PortChQueryFrom(String name) {
		super(name);
	}

	public void receiveFromSecurityQuery(Object arg) {
		this.setChanged();
		this.notifyObservers(arg);
	}
}
