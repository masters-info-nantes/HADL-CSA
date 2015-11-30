package hadl.m1.serveur.composants.connectionManager;

import java.util.Observable;
import java.util.Observer;

import hadl.m2.interfaces.services.ServiceCptConfigRequis;

public class ServiceDatabaseQueryFrom extends ServiceCptConfigRequis implements Observer{
	
	public ServiceDatabaseQueryFrom(String name) {
		super(name);
		
		PortDatabaseQueryFrom portDatabaseQueryFrom = new PortDatabaseQueryFrom("portDatabaseQueryFrom");
		portDatabaseQueryFrom.addObserver(this);
        addPorts(portDatabaseQueryFrom);
	}

	@Override
    public void update(Observable o, Object arg) {

        if (o instanceof PortDatabaseQueryFrom) {
            setChanged();
            notifyObservers(arg);
        }
    }
}
