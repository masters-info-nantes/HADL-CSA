package hadl.m1.serveur.composants.connectionManager;

import java.util.Observable;
import java.util.Observer;

import hadl.m1.messages.*;
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
			System.out.println(this.getClass().getSimpleName() + " : Reception from Serveur");
			if(arg instanceof Query){
				sendRequest(arg);
			}else if(arg instanceof Response){
				sendResponse(arg);
			}
		} else if (o instanceof ServiceSecurityCheckFrom) {
			System.out.println(this.getClass().getSimpleName() + " : Reception from Security Manager");
			if(arg instanceof Response){
				sendResponse(arg);
			}else if(arg instanceof Query){
				sendRequest(arg);
			}
		} else if (o instanceof ServiceDatabaseQueryFrom) {
			System.out.println(this.getClass().getSimpleName() + " : Reception from Database");
			if(arg instanceof Response){
				sendResponse(arg);
			}else if(arg instanceof Query){
				sendRequest(arg);
			}
		}
	}
	
	public void sendRequest(Object query){
		if(((Query)query).getHeader().equals("authentification")){
			serviceSecurityCheckTo.sendToClearanceRequest(query);
		}else if(((Query)query).getHeader().equals("requeteBDD")){
			serviceDatabaseQueryTo.sendToSqlQuery(query);
		}else{
			System.out.println("(ConnectionManager) sendRequest : Type de requête inconnu.");
		}
	}
	
	public void sendResponse(Object resp){
		serviceExternalSocketTo.sendToServeur(resp);
	}

	//// TODO: 30/11/15 METHODE THE CONTROLE manager
}
