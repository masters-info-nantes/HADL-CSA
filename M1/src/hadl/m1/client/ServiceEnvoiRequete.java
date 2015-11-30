package hadl.m1.client;

import hadl.m2.interfaces.services.ServiceCptConfigFourni;

public class ServiceEnvoiRequete extends ServiceCptConfigFourni {

	public ServiceEnvoiRequete(String name) {
		super(name);
		PortEnvoiRequete portEnvoiRequete = new PortEnvoiRequete(
				"PortEnvoiRequete");
		this.addPort(portEnvoiRequete);
	}

	public void sendRequest(Object message) {
		PortEnvoiRequete per = (PortEnvoiRequete) this
				.getPort("PortEnvoiRequete");

		per.sendRequest(message);
	}

}
