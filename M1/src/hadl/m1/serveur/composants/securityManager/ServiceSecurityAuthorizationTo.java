package hadl.m1.serveur.composants.securityManager;

import hadl.m2.interfaces.services.ServiceCptConfigFourni;

public class ServiceSecurityAuthorizationTo extends ServiceCptConfigFourni {

    protected ServiceSecurityAuthorizationTo(String name) {
		super(name);
		PortSecurityAuthorizationTo portSecurityAuthorizationTo = new PortSecurityAuthorizationTo("portSecurityAuthorizationTo");
		addPort(portSecurityAuthorizationTo);
	}

}
