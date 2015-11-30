package hadl.m1.serveur.serveurComposant;

import java.util.Observable;
import java.util.Observer;

import hadl.m2.interfaces.ports.PortCptConfigRequis;
import hadl.m2.interfaces.services.ServiceCptConfigRequis;

public class ServiceConnectionTo extends ServiceCptConfigRequis implements Observer {

	public ServiceConnectionTo(String name) {
		super(name);

		ports.add(new PortCptConfigRequis("PortServeurConfigRequis"));
	}

	@Override
	public void update(Observable o, Object arg) {
		ports.add(new PortCptConfigRequis("PortCptConfigRequis"));
	}

}
