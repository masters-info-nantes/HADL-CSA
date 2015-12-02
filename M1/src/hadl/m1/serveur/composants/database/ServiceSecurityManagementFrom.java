package hadl.m1.serveur.composants.database;

import hadl.m2.interfaces.services.ServiceCptConfigRequis;

import java.util.Observable;
import java.util.Observer;

public class ServiceSecurityManagementFrom extends ServiceCptConfigRequis implements Observer {

	public ServiceSecurityManagementFrom(String name) {
		super(name);
        PortSecurityManagementFrom portSecurityManagementFrom = new PortSecurityManagementFrom("portSecurityManagementFrom");
        portSecurityManagementFrom.addObserver(this);
        addPorts(portSecurityManagementFrom);
	}

    @Override
    public void update(Observable o, Object arg) {

    	if( o instanceof PortSecurityManagementFrom) {
    		System.out.println(this.getClass().getSimpleName()+" -> Database");
            setChanged();
            notifyObservers(arg);
        }
    }
}
