package hadl.m1.serveur.serveurComposant;

import hadl.m2.interfaces.ports.PortCptConfigRequis;
import hadl.m2.interfaces.services.ServiceCptConfigRequis;

public class ServiceConnectionTo extends ServiceCptConfigRequis  {

	public ServiceConnectionTo(String name) {
		super(name);
        PortCptConfigRequis portServeurConfigRequis = new PortCptConfigRequis("PortServeurConfigRequis");
        ports.add(portServeurConfigRequis);
	}


    public void sendRequest(Object arg) {

        ((PortServeurCptRequis)this.getPort("portServeurCptRequis")).sendRequest(arg);
    }


}
