package hadl.m1.serveur.composants.connectionManager;

import hadl.m2.interfaces.services.ServiceCptConfigFourni;

public class ServiceSecurityCheckTo extends ServiceCptConfigFourni {


	public ServiceSecurityCheckTo(String name) {
		super(name);
        PortSecurityCheckTo portSecurityCheckTo = new PortSecurityCheckTo("portSecurityCheckTo");
        addPort(portSecurityCheckTo);
	}

    public void sendRequest(Object arg) {
        ((PortSecurityCheckTo) getPort("PortSecurityCheckTo")).sendRequest(arg);
    }
}
