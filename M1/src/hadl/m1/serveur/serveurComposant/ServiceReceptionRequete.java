package hadl.m1.serveur.serveurComposant;

import hadl.m2.interfaces.services.ServiceCptConfigRequis;

import java.util.Observable;
import java.util.Observer;

public class ServiceReceptionRequete extends ServiceCptConfigRequis implements Observer {

	public ServiceReceptionRequete(String name) {
		super(name);

        PortReceptionRequete portReceptionRequete  = new PortReceptionRequete("portReceptionRequete");
        portReceptionRequete.addObserver(this);
        addPorts(portReceptionRequete);

	}


    @Override
    public void update(Observable o, Object arg) {
           if(o instanceof PortReceptionRequete) {
               setChanged();
               notifyObservers(arg);
           }
    }
}
