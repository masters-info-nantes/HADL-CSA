package hadl.m1.serveur.composants.database;

import hadl.m2.interfaces.services.ServiceCptConfigFourni;

public class ServiceQueryDatabaseTo extends ServiceCptConfigFourni {

	public ServiceQueryDatabaseTo(String name) {
		super(name);
		
        PortQueryDatabaseTo portQueryDatabaseTo = new PortQueryDatabaseTo("portQueryDatabaseTo");
        addPort(portQueryDatabaseTo);
	}

	public void sendToSqlQuery(Object arg) {
        ((PortQueryDatabaseTo) getPort("portQueryDatabaseTo")).sendToSqlQuery(arg);
    }
}
