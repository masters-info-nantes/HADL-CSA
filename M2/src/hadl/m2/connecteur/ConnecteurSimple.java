package hadl.m2.connecteur;

import hadl.m2.interfaces.InterfaceConnecteur;

import java.util.ArrayList;

public class ConnecteurSimple extends Connecteur {

	public ConnecteurSimple() {
		listInterfaces = new ArrayList<InterfaceConnecteur>();
	}

	protected void glue() {
	}
}
