package hadl.m1.serveur.composants.connectionManager;

import hadl.m1.messages.Message;
import hadl.m1.messages.Query;
import hadl.m1.messages.Response;
import hadl.m2.composant.ComposantConfiguration;

import java.util.Observable;
import java.util.Observer;

public class ConnectionManager extends ComposantConfiguration implements Observer {

    private ServiceExternalSocketFrom serviceExternalSocketFrom;
    private ServiceExternalSocketTo serviceExternalSocketTo;

    private ServiceSecurityCheckFrom serviceSecurityCheckFrom;
    private ServiceSecurityCheckTo serviceSecurityCheckTo;

    private ServiceDatabaseQueryTo serviceDatabaseQueryTo;
    private ServiceDatabaseQueryFrom serviceDatabaseQueryFrom;

    public ConnectionManager(String name) {
        super(name);

        serviceExternalSocketFrom = new ServiceExternalSocketFrom("serviceExternalSocketFrom");
        serviceExternalSocketTo = new ServiceExternalSocketTo("serviceExternalSocketTo");

        serviceSecurityCheckFrom = new ServiceSecurityCheckFrom("ServiceSecurityCheckFrom");
        serviceSecurityCheckTo = new ServiceSecurityCheckTo("ServiceSecurityCheckTo");

        serviceDatabaseQueryFrom = new ServiceDatabaseQueryFrom("serviceDatabaseQueryFrom");
        serviceDatabaseQueryTo = new ServiceDatabaseQueryTo("serviceDatabaseQueryTo");
        addService(serviceExternalSocketTo);
        addService(serviceExternalSocketFrom);

        addService(serviceSecurityCheckFrom);
        addService(serviceSecurityCheckTo);

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
            }
        } else if (o instanceof ServiceSecurityCheckFrom) {
            System.out.println(this.getClass().getSimpleName() + " : Reception from Security Manager");
            if(arg instanceof Response){
                sendResponse(arg);
            }
        } else if (o instanceof ServiceDatabaseQueryFrom) {
            System.out.println(this.getClass().getSimpleName() + " : Reception from Database");
            if(arg instanceof Response){
                sendResponse(arg);
            }
        }
    }

    public void sendRequest(Object query){
        if(((Query)query).getHeader().equals(Message.HeaderType.AUTHENTIFICATION)){

            serviceSecurityCheckTo.sendToClearanceRequest(query);

        }else if(((Query)query).getHeader().equals(Message.HeaderType.BDDREQUEST)){

            serviceDatabaseQueryTo.sendToSqlQuery(query);

        }else{

            System.out.println("(ConnectionManager) sendRequest : Unknown Type request, stopping diffusion.");

        }
    }

    public void sendResponse(Object resp){
        serviceExternalSocketTo.sendToServeur(resp);
    }


}
