package hadl.m2.connecteur;

import hadl.m2.interfaces.InterfaceConnecteur;

public class ConnecteurSimple extends Connecteur {

	public ConnecteurSimple() {
		interfaceConnecteur = new InterfaceConnecteur();
	}

	public ConnecteurSimple(String name) {
		this.name = name;
	}

	protected void glue() {
	}
}
