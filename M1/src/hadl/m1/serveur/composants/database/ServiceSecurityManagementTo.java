package hadl.m1.serveur.composants.database;

import hadl.m2.interfaces.services.ServiceCptConfigFourni;

public class ServiceSecurityManagementTo extends ServiceCptConfigFourni {

	public ServiceSecurityManagementTo(String name) {
		super(name);
		
        PortSecurityManagementTo portSecurityManagementTo = new PortSecurityManagementTo("portSecurityManagementTo");
        addPort(portSecurityManagementTo);
	}

	public void sendToSecurityQuery(Object arg) {
        ((PortSecurityManagementTo) getPort("portSecurityManagementTo")).sendToSecurityQuery(arg);
    }
}
