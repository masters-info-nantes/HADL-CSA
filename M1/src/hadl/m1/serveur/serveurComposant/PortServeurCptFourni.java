package hadl.m1.serveur.serveurComposant;

import hadl.m2.interfaces.ports.PortCptConfigFourni;

public class PortServeurCptFourni extends PortCptConfigFourni {

	public PortServeurCptFourni(String name) {
		super(name);

	}

    public void sendRequest(Object arg) {
        setChanged();
        notifyObservers(arg);
    }
}
