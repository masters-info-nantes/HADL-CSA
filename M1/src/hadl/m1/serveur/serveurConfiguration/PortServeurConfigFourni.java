package hadl.m1.serveur.serveurConfiguration;

import hadl.m2.interfaces.ports.PortConfigFourni;

public class PortServeurConfigFourni extends PortConfigFourni {

	public PortServeurConfigFourni(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void sendResponse(Object arg) {
        setChanged();
        notifyObservers(arg);
	}
}
