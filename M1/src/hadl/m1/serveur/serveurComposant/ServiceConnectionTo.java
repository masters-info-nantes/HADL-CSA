package hadl.m1.serveur.serveurComposant;

import hadl.m1.serveur.serveurConfiguration.PortServeurConfigRequis;
import hadl.m2.interfaces.services.ServiceCptConfigRequis;

public class ServiceConnectionTo extends ServiceCptConfigRequis {

	public ServiceConnectionTo(String name) {
		super(name);
		this.ports.add(new PortServeurConfigRequis("PortServeurConfigRequis"));
	}

	public void post(Object arg) {
		((PortServeurConfigRequis) this.getInterface("PortServeurConfigRequis"))
				.post(arg);
	}

}
