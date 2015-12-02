package hadl.m1.serveur.composants.connectionManager;

import hadl.m2.interfaces.services.ServiceCptConfigRequis;

import java.util.Observable;
import java.util.Observer;

public class ServiceSecurityCheckFrom extends ServiceCptConfigRequis implements Observer{

	public ServiceSecurityCheckFrom(String name) {
		super(name);
		
		PortSecurityCheckFrom portSecurityCheckFrom = new PortSecurityCheckFrom("portSecurityCheckFrom");
		portSecurityCheckFrom.addObserver(this);
        addPorts(portSecurityCheckFrom);
	}

    @Override
    public void update(Observable o, Object arg) {

        if (o instanceof PortSecurityCheckFrom) {
        	System.out.println(this.getClass().getSimpleName()+" -> ConnectionManager");
            setChanged();
            notifyObservers(arg);
        }
    }
}
