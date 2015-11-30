package hadl.m1.serveur.composants.database;

import hadl.m2.interfaces.services.ServiceCptConfigRequis;

import java.util.Observable;
import java.util.Observer;

public class ServiceQueryDatabaseFrom extends ServiceCptConfigRequis implements Observer {

	public ServiceQueryDatabaseFrom(String name) {
		super(name);
		PortQueryDatabaseFrom portQueryDatabaseFrom = new PortQueryDatabaseFrom("portQueryDatabaseFrom");
        portQueryDatabaseFrom.addObserver(this);
        addPorts(portQueryDatabaseFrom);
	}

    @Override
    public void update(Observable o, Object arg) {

    	if( o instanceof PortQueryDatabaseFrom) {
            setChanged();
            notifyObservers();
        }
    }
}
