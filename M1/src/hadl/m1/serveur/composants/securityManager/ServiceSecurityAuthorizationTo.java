package hadl.m1.serveur.composants.securityManager;

import hadl.m2.interfaces.services.ServiceCptConfigFourni;

public class ServiceSecurityAuthorizationTo extends ServiceCptConfigFourni {

	public ServiceSecurityAuthorizationTo(String name) {
		super(name);
		
		PortSecurityAuthorizationTo portSecurityAuthorizationTo = new PortSecurityAuthorizationTo("portSecurityAuthorizationTo");
		addPort(portSecurityAuthorizationTo);
	}

	public void sendToClearanceRequest(Object arg) {

        ((PortSecurityAuthorizationTo) getPort("portSecurityAuthorizationTo")).sendToClearanceRequest(arg);
    }
}
