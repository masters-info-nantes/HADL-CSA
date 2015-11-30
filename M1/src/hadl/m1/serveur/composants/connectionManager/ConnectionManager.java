package hadl.m1.serveur.composants.connectionManager;

import java.util.Observable;
import java.util.Observer;

import hadl.m2.composant.ComposantConfiguration;

public class ConnectionManager extends ComposantConfiguration implements Observer {

	private ServiceExternalSocketFrom serviceExternalSocketFrom;
	private ServiceExternalSocketTo serviceExternalSocketTo;

	private ServiceSecurityCheckFrom serviceSecurityCheckFrom;
	private ServiceSecurityCheckTo serviceSecurityCheckTo;

	private ServiceDatabaseQueryTo serviceDatabaseQueryTo;
	private ServiceDatabaseQueryFrom serviceDatabaseQueryFrom;

	public ConnectionManager(String name) {
		super(name);

		serviceExternalSocketFrom = new ServiceExternalSocketFrom("serviceExternalSocketFromService");
		serviceExternalSocketTo = new ServiceExternalSocketTo("serviceExternalSocketToService");

		serviceSecurityCheckFrom = new ServiceSecurityCheckFrom("serviceDatabaseQueryFrom");
		serviceSecurityCheckTo = new ServiceSecurityCheckTo("serviceDatabaseQueryTo");

		serviceDatabaseQueryFrom = new ServiceDatabaseQueryFrom("serviceDatabaseQueryFrom");
		serviceDatabaseQueryTo = new ServiceDatabaseQueryTo("serviceDatabaseQueryTo");

		addService(serviceExternalSocketTo);
		addService(serviceExternalSocketFrom);

		addService(serviceSecurityCheckFrom);
		addService(serviceExternalSocketTo);

		addService(serviceDatabaseQueryTo);
		addService(serviceDatabaseQueryFrom);

		serviceDatabaseQueryFrom.addObserver(this);
		serviceExternalSocketFrom.addObserver(this);
		serviceSecurityCheckTo.addObserver(this);

	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof ServiceExternalSocketFrom) {
			// serviceExternalSocketTo.getPort().sendRequete(arg);
		} else if (o instanceof ServiceSecurityCheckFrom) {
			// serviceSecurityCheckTo.getPort().sendRequete(arg);
		} else if (o instanceof ServiceDatabaseQueryFrom) {
			// serviceDatabaseQueryTo.getPort().sendRequete(arg);
		}
	}

	//// TODO: 30/11/15 METHODE THE CONTROLE manager
}
