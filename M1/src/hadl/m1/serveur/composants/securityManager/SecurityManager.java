package hadl.m1.serveur.composants.securityManager;

import hadl.m1.messages.Response;
import hadl.m2.composant.ComposantConfiguration;

import java.util.Observable;
import java.util.Observer;

public class SecurityManager extends ComposantConfiguration implements Observer {

    public SecurityManager(String name) {
        super(name);

        ServiceSecurityAuthorizationFrom serviceSecurityAuthorizationFrom = new ServiceSecurityAuthorizationFrom("serviceSecurityAuthorizationFrom");
        ServiceSecurityAuthorizationTo serviceSecurityAuthorizationTo = new ServiceSecurityAuthorizationTo("serviceSecurityAuthorizationTo");

        ServiceChQueryFrom serviceChQueryFrom = new ServiceChQueryFrom("serviceChQueryFrom");
        ServiceChQueryTo serviceChQueryTo = new ServiceChQueryTo("serviceChQueryTo");

        serviceChQueryFrom.addObserver(this);
        serviceSecurityAuthorizationFrom.addObserver(this);

        addService(serviceChQueryFrom);
        addService(serviceChQueryTo);
        addService(serviceSecurityAuthorizationFrom);
        addService(serviceSecurityAuthorizationTo);

        serviceChQueryFrom.addObserver(this);
        serviceSecurityAuthorizationFrom.addObserver(this);
    }
    
    @Override
    public void update(Observable o, Object arg) {

        if(o instanceof ServiceChQueryFrom) {
            if(arg instanceof Response) {
            	System.out.println("\n   "+this.getClass().getSimpleName()+"  : Receive from Database");
                if(((Response) arg).getSuccess().equals(false)){

                    Response response = new Response("Authentification failed",false);
                    ((ServiceSecurityAuthorizationTo)getInterfaceService("ServiceSecurityAuthorizationTo")).sendToClearanceRequest(response);

                }else{
                    Response response = new Response("Authentification succeed",true);
                    ((ServiceSecurityAuthorizationTo)getInterfaceService("ServiceSecurityAuthorizationTo")).sendToClearanceRequest(response);
                }

            }
        }else if (o instanceof ServiceSecurityAuthorizationFrom) {
        	System.out.println("\n   "+this.getClass().getSimpleName()+"  : Receive from ConnectionManager");
            ((ServiceChQueryTo)getInterfaceService("ServiceChQueryTo")).sendToSecurityQuery(arg);
        }

    }

}
