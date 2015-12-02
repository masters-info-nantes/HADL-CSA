package hadl.m1.serveur.serveurComposant;

import hadl.m2.interfaces.ports.PortCptConfigFourni;
import hadl.m2.interfaces.services.ServiceCptConfigFourni;

import java.util.Observable;
import java.util.Observer;

public class ServiceConnectionFrom extends ServiceCptConfigFourni implements Observer {

	public ServiceConnectionFrom(String name) {
        super(name);
	    PortServeurCptFourni portServeurCptFourni = new PortServeurCptFourni("portServeurCptFourni");
        portServeurCptFourni.addObserver(this);
        addPort(portServeurCptFourni);
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof PortCptConfigFourni) {
        	System.out.println(this.getClass().getSimpleName()+" -> ServeurComposant");
            setChanged();
            notifyObservers(arg);
        }
    }


}
