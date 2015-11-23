package hadl.m2.connecteur;

import java.util.ArrayList;

import hadl.m2.interfaces.InterfaceConnecteur;

public class ConnecteurSimple extends Connecteur {

	public ConnecteurSimple() {
		listInterfaces = new ArrayList<InterfaceConnecteur>();
	}

	protected void glue() {
	}
}
