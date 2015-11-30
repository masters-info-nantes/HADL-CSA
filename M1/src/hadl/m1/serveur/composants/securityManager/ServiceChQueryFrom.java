package hadl.m1.serveur.composants.securityManager;

import hadl.m2.interfaces.services.ServiceCptConfigRequis;

import java.util.Observable;
import java.util.Observer;

public class ServiceChQueryFrom extends ServiceCptConfigRequis implements Observer {

	public ServiceChQueryFrom(String name) {
		super(name);
		
		PortChQueryFrom portChQueryFrom = new PortChQueryFrom("portChQueryFrom");
		portChQueryFrom.addObserver(this);
		addPorts(portChQueryFrom);
	}

	@Override
	public void update(Observable o, Object arg) {

		if( o instanceof PortChQueryFrom) {
            setChanged();
            notifyObservers();
        }
	}
}
