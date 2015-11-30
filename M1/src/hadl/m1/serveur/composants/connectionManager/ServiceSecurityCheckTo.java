package hadl.m1.serveur.composants.connectionManager;

import hadl.m2.interfaces.services.ServiceCptConfigFourni;

public class ServiceSecurityCheckTo extends ServiceCptConfigFourni {
	private PortSecurityCheckTo portSecurityCheckTo;

	public ServiceSecurityCheckTo(String name) {
		super(name);

	}

	public PortSecurityCheckTo getPort() {
	    return portSecurityCheckTo;
    }
}
