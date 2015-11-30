package hadl.m1.serveur.composants.connectionManager;

import hadl.m2.interfaces.services.ServiceCptConfigFourni;

public class ServiceExternalSocketTo extends ServiceCptConfigFourni {
	private PortExternalSocketTo portExternalSocketTo;

	public ServiceExternalSocketTo(String name) {
		super(name);
		;
		portExternalSocketTo = new PortExternalSocketTo("portExternalSocketTo");

	}

	public PortExternalSocketTo getPort() {
		return portExternalSocketTo;

	}


}
