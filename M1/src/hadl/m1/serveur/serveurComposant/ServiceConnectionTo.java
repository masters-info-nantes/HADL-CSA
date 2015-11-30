package hadl.m1.serveur.serveurComposant;

import hadl.m2.interfaces.ports.PortCptConfigRequis;
import hadl.m2.interfaces.services.ServiceCptConfigRequis;

public class ServiceConnectionTo extends ServiceCptConfigRequis {

	public ServiceConnectionTo(String name) {
		super(name);
		ports.add(new PortCptConfigRequis("PortCptConfigRequis"));
	}

	public void post(Object arg) {
		getInterface("PortServeurConfigRequis").post(arg);
	}

}
