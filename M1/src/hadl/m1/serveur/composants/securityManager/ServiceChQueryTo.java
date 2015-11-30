package hadl.m1.serveur.composants.securityManager;

import hadl.m2.interfaces.services.ServiceCptConfigFourni;

public class ServiceChQueryTo extends ServiceCptConfigFourni {

	public ServiceChQueryTo(String name) {
		super(name);
		
		PortChQueryTo portChQueryTo = new PortChQueryTo("portChQueryTo");;
		addPort(portChQueryTo);
	}

	public void sendToSecurityQuery(Object arg) {
        ((PortChQueryTo) getPort("portChQueryTo")).sendToSecurityQuery(arg);
    }
}
