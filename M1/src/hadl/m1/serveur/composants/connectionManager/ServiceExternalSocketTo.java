package hadl.m1.serveur.composants.connectionManager;

import hadl.m2.interfaces.services.ServiceCptConfigFourni;

public class ServiceExternalSocketTo extends ServiceCptConfigFourni {

	public ServiceExternalSocketTo(String name) {
		super(name);

		PortExternalSocketTo portExternalSocketTo = new PortExternalSocketTo("portExternalSocketTo");
        addPort(portExternalSocketTo);
	}

    public void sendToServeur(Object arg) {
    	System.out.print("	< "+this.getClass().getSimpleName()+" -> ");
        ((PortExternalSocketTo) getPort("portExternalSocketTo")).sendToServeur(arg);
    }
}
