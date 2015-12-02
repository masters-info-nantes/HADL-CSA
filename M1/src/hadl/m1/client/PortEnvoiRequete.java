package hadl.m1.client;

import hadl.m2.interfaces.ports.PortCptConfigFourni;

public class PortEnvoiRequete extends PortCptConfigFourni {

	public PortEnvoiRequete(String name) {
		super(name);

	}

	public void sendRequest(Object message) {
		System.out.print(this.getClass().getSimpleName()+" -> ");
        this.setChanged();
        this.notifyObservers(message);
	}


}
