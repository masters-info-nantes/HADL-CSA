package hadl.m1.serveur.serveurComposant;

import hadl.m2.interfaces.ports.PortCptConfigRequis;
import hadl.m2.interfaces.services.ServiceCptConfigRequis;

import java.util.Observable;
import java.util.Observer;

public class ServiceConnectionTo extends ServiceCptConfigRequis implements Observer {

	public ServiceConnectionTo(String name) {
		super(name);
		this.ports.add(new PortCptConfigRequis("PortServeurConfigRequis"));
	}

    @Override
    public void update(Observable o, Object arg) {

    }
}
