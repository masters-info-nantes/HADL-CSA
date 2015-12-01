package hadl.m1.serveur.composants.connectionManager;

import hadl.m2.interfaces.services.ServiceCptConfigRequis;

import java.util.Observable;
import java.util.Observer;

public class ServiceExternalSocketFrom extends ServiceCptConfigRequis implements Observer{

	public ServiceExternalSocketFrom(String name) {
		super(name);
		
		PortExternalSocketFrom portExternalSocketFrom = new PortExternalSocketFrom("portExternalSocketFrom");
        portExternalSocketFrom.addObserver(this);
        addPorts(portExternalSocketFrom);
	}

    @Override
    public void update(Observable o, Object arg) {
    	
        if( o instanceof PortExternalSocketFrom ) {
            setChanged();
            notifyObservers();
        }
    }
}
