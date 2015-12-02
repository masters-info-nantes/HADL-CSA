package hadl.m1.serveur.composants.connectionManager;

import hadl.m2.interfaces.services.ServiceCptConfigFourni;

public class ServiceDatabaseQueryTo extends ServiceCptConfigFourni {

	public ServiceDatabaseQueryTo(String name) {
		super(name);
		
		PortDatabaseQueryTo portDatabaseQueryTo = new PortDatabaseQueryTo("portDatabaseQueryTo");
        addPort(portDatabaseQueryTo);
	}
	
	public void sendToSqlQuery(Object arg) {
		System.out.print("	> "+this.getClass().getSimpleName()+" -> ");
        ((PortDatabaseQueryTo) getPort("portDatabaseQueryTo")).sendToSqlQuery(arg);
    }
}
