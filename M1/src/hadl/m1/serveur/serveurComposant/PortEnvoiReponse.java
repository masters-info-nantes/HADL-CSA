package hadl.m1.serveur.serveurComposant;

import hadl.m2.interfaces.ports.PortCptConfigFourni;

public class PortEnvoiReponse extends PortCptConfigFourni {

	public PortEnvoiReponse(String name) {
		super(name);
	}

	public void post(Object arg) {
		this.setChanged();
		this.notifyObservers(arg);
	}

}
