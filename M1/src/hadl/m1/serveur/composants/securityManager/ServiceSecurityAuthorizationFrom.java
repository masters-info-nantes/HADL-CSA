package hadl.m1.serveur.composants.securityManager;

import hadl.m2.interfaces.services.ServiceCptConfigRequis;

import java.util.Observable;
import java.util.Observer;

public class ServiceSecurityAuthorizationFrom extends ServiceCptConfigRequis implements Observer {

	public ServiceSecurityAuthorizationFrom(String name) {
		super(name);
		
		PortSecurityAuthorizationFrom portSecurityAuthorizationFrom = new PortSecurityAuthorizationFrom("portSecurityAuthorizationFrom");
		addPorts(portSecurityAuthorizationFrom);
        portSecurityAuthorizationFrom.addObserver(this);
	}

    @Override
    public void update(Observable o, Object arg) {

    	if( o instanceof  PortSecurityAuthorizationFrom) {
            setChanged();
            notifyObservers();
        }
    }
}
