package hadl.m1.client;

import hadl.m2.interfaces.services.ServiceCptConfigRequis;

import java.util.Observable;
import java.util.Observer;

public class ServiceReceptionReponse extends ServiceCptConfigRequis implements Observer {

	public ServiceReceptionReponse(String name) {
		super(name);
        PortReceptionReponse portReceptionReponse = new PortReceptionReponse("PortReceptionReponse");
        addPorts(portReceptionReponse);
        portReceptionReponse.addObserver(this);

	}


    @Override
    public void update(Observable o, Object arg) {

        setChanged();
        notifyObservers(arg);
    }
}
