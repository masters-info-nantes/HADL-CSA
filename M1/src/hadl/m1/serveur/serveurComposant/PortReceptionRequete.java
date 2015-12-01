package hadl.m1.serveur.serveurComposant;

import hadl.m2.interfaces.ports.PortCptConfigRequis;

public class PortReceptionRequete extends PortCptConfigRequis {

	public PortReceptionRequete(String name) {
		super(name);
	}

	public void getRequete(Object arg) {
        System.out.println("receiven requete");
        this.setChanged();
		this.notifyObservers(arg);
	}

}
