package hadl.m1.serveur.serveurComposant;

import hadl.m2.interfaces.services.ServiceCptConfigFourni;

public class ServiceEnvoiReponse extends ServiceCptConfigFourni {

	public ServiceEnvoiReponse(String name) {
		super(name);

		this.ports.add(new PortEnvoiReponse("PortEnvoiReponse"));
	}

	public void post(Object arg) {
		((PortEnvoiReponse) this.getPort("PortEnvoiReponse")).post(arg);
	}
}
