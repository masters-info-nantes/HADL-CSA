package hadl.m1.serveur.serveurComposant;

import hadl.m2.interfaces.services.ServiceCptConfigFourni;

public class ServiceConnectionFrom extends ServiceCptConfigFourni {

	public ServiceConnectionFrom(String name) {
        super(name);
	    PortServeurCptFourni portServeurCptFourni = new PortServeurCptFourni("portServeurCptFourni");

        addPort(portServeurCptFourni);
    }

    public void sendRequest(Object arg) {
        ((PortServeurCptFourni) getPort("portServeurCptFourni")).sendRequest(arg);
    }
}
