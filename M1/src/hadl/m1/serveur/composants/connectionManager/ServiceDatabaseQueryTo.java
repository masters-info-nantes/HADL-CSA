package hadl.m1.serveur.composants.connectionManager;

import hadl.m1.serveur.composants.database.PortQueryDatabaseTo;
import hadl.m2.interfaces.services.ServiceCptConfigFourni;

public class ServiceDatabaseQueryTo extends ServiceCptConfigFourni {

	private PortQueryDatabaseTo portQueryDatabaseTo;

	public ServiceDatabaseQueryTo(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public PortQueryDatabaseTo getPort() {
		return portQueryDatabaseTo;
	}
}
