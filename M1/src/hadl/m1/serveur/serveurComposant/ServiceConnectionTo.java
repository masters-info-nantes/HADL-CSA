package hadl.m1.serveur.serveurComposant;

import hadl.m2.interfaces.services.ServiceCptConfigRequis;

public class ServiceConnectionTo extends ServiceCptConfigRequis  {

	public ServiceConnectionTo(String name) {
		super(name);
        PortServeurCptRequis portServeurCptRequis =new PortServeurCptRequis("PortServeurCptRequis");
        ports.add(portServeurCptRequis);
	}


    public void sendRequest(Object arg) {

        ((PortServeurCptRequis)this.getPort("portServeurCptRequis")).sendRequest(arg);
    }


}
