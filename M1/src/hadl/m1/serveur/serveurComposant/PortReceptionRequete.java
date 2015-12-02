package hadl.m1.serveur.serveurComposant;

import hadl.m2.interfaces.ports.PortCptConfigRequis;

public class PortReceptionRequete extends PortCptConfigRequis {

	public PortReceptionRequete(String name) {
		super(name);
	}

	public void getRequete(Object arg) {
		System.out.print(this.getClass().getSimpleName()+" -> ");
        this.setChanged();
		this.notifyObservers(arg);
	}

}
