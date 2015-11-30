package hadl.m1.serveur.composants.connectionManager;

import hadl.m2.interfaces.services.ServiceCptConfigFourni;

public class ServiceExternalSocketToService extends ServiceCptConfigFourni {
	private PortExternalSocketTo portExternalSocketTo;

	public ServiceExternalSocketToService(String name) {
		super(name);
		;
		portExternalSocketTo = new PortExternalSocketTo("portExternalSocketTo");

	}

	public PortExternalSocketTo getPort() {
		return portExternalSocketTo;

	}


}
