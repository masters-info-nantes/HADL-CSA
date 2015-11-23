package alma.m2.connecteur;

import java.util.ArrayList;

import alma.m2.interfaces.InterfaceConnecteur;

public class ConnecteurSimple extends Connecteur {

	public ConnecteurSimple() {
		listInterfaces = new ArrayList<InterfaceConnecteur>();
	}

	protected void glue() {
	}
}
