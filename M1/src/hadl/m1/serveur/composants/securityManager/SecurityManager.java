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
                if(((Response) arg).getSuccess().equals(false)){
                    Response response = new Response("Authentification False",false);
                    ((ServiceSecurityAuthorizationTo)getInterfaceElement("ServiceSecurityAuthorizationTo")).sendToClearanceRequest(response);
                }else{
                    ((ServiceSecurityAuthorizationTo)getInterfaceElement("ServiceSecurityAuthorizationTo")).sendToClearanceRequest(arg);
                }

            }
        }else if (o instanceof ServiceSecurityAuthorizationFrom) {
            ((ServiceChQueryTo)getInterfaceElement("ServiceChQueryTo")).sendToSecurityQuery(arg);
        }

    }

}
