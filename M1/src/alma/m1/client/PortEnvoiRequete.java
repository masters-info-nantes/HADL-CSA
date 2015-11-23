package alma.m1.client;

import hadl.m2.interfaces.ports.PortCptConfigFourni;

public class PortEnvoiRequete extends PortCptConfigFourni {

	public PortEnvoiRequete(String name) {
		super(name);

	}

	public void sendMessage(Object message) {
		this.setChanged();
		this.notifyObservers(message);

	}

}
