package hadl.m1.serveur.composants.connectionManager;

import hadl.m2.interfaces.ports.PortCptConfigRequis;

public class PortSecurityCheckFrom extends PortCptConfigRequis {

	public PortSecurityCheckFrom(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

    public void sendResponse(Object arg) {
        setChanged();
        notifyObservers(arg);
    }
}
