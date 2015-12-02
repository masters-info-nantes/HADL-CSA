package hadl.m1.serveur.serveurConfiguration;

import hadl.m2.interfaces.ports.PortConfigFourni;

public class PortServeurConfigFourni extends PortConfigFourni {

	public PortServeurConfigFourni(String name) {
		super(name);
	}

	public void sendResponse(Object arg) {
		System.out.print("	< "+this.getClass().getSimpleName()+" -> ");
        setChanged();
        notifyObservers(arg);
	}
}
