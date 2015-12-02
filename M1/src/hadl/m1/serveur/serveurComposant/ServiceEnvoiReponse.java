package hadl.m1.serveur.serveurComposant;

import hadl.m2.interfaces.services.ServiceCptConfigFourni;

public class ServiceEnvoiReponse extends ServiceCptConfigFourni {

	public ServiceEnvoiReponse(String name) {
		super(name);

		this.ports.add(new PortEnvoiReponse("PortEnvoiReponse"));
	}

    public void sendResponse(Object arg) {
    	System.out.print("	< "+this.getClass().getSimpleName()+" -> ");
        ((PortEnvoiReponse) this.getPort("PortEnvoiReponse")).sendReponse(arg);
    }
}
