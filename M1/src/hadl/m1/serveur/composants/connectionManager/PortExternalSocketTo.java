package hadl.m1.serveur.composants.connectionManager;

import hadl.m2.interfaces.ports.PortCptConfigFourni;

public class PortExternalSocketTo extends PortCptConfigFourni {

	public PortExternalSocketTo(String name) {
		super(name);
	}

    public void sendToServeur(Object arg) {
        this.setChanged();
        this.notifyObservers(arg);
    }
}
