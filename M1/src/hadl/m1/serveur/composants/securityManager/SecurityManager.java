package hadl.m1.serveur.composants.securityManager;

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

        addInterface(serviceChQueryFrom);
        addInterface(serviceChQueryTo);
        addInterface(serviceSecurityAuthorizationFrom);
        addInterface(serviceSecurityAuthorizationTo);


    }


    @Override
    public void update(Observable o, Object arg) {

    }
}
