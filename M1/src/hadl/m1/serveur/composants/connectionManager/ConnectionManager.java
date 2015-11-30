package hadl.m1.serveur.composants.connectionManager;

import hadl.m2.composant.ComposantConfiguration;

import java.util.Observable;
import java.util.Observer;

public class ConnectionManager extends ComposantConfiguration implements Observer {

    private ServiceExternalSocketFromService serviceExternalSocketFromService;
    private ServiceExternalSocketToService serviceExternalSocketToService;

    private ServiceSecurityCheckFrom serviceSecurityCheckFrom;
    private ServiceSecurityCheckTo serviceSecurityCheckTo;

    private ServiceDatabaseQueryTo serviceDatabaseQueryTo;
    private ServiceDatabaseQueryFrom serviceDatabaseQueryFrom;





	public ConnectionManager(String name) {
		super(name);


        serviceExternalSocketFromService = new ServiceExternalSocketFromService("serviceExternalSocketFromService");
        serviceExternalSocketToService = new ServiceExternalSocketToService("serviceExternalSocketToService");


        serviceSecurityCheckFrom = new ServiceSecurityCheckFrom("serviceDatabaseQueryFrom");
        serviceSecurityCheckTo = new ServiceSecurityCheckTo("serviceDatabaseQueryTo");


        serviceDatabaseQueryFrom = new ServiceDatabaseQueryFrom("serviceDatabaseQueryFrom");
        serviceDatabaseQueryTo = new ServiceDatabaseQueryTo("serviceDatabaseQueryTo");

        addService(serviceExternalSocketToService);
        addService(serviceExternalSocketFromService);

        addService(serviceSecurityCheckFrom);
        addService(serviceExternalSocketToService);

        addService(serviceDatabaseQueryTo);
        addService(serviceDatabaseQueryFrom);


        serviceDatabaseQueryFrom.addObserver(this);
        serviceExternalSocketFromService.addObserver(this);
        serviceSecurityCheckTo.addObserver(this);


	}


    @Override
    public void update(Observable o, Object arg) {
        if( o instanceof  ServiceExternalSocketFromService){
             serviceExternalSocketToService.getPort().sendRequete(arg);
        }else if( o instanceof ServiceSecurityCheckFrom){
            serviceSecurityCheckTo.getPort().sendRequete(arg);
        }else if( o instanceof ServiceDatabaseQueryFrom) {
            serviceDatabaseQueryTo.getPort().sendRequete(arg);
        }
    }

    //// TODO: 30/11/15 METHODE THE CONTROLE manager
}




