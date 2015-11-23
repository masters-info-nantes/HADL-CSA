package hadl.m2.connecteur;

import hadl.m2.interfaces.InterfaceConnecteur;

import java.util.ArrayList;

public class ConnecteurSimple extends Connecteur {

	public ConnecteurSimple() {
		listInterfaces = new ArrayList<InterfaceConnecteur>();
	}

	@Override
	public void addInterface(InterfaceConnecteur ic) {
		listInterfaces.add(ic);
	}

	public InterfaceConnecteur getInterface(String roleName) {
		for (InterfaceConnecteur ic : listInterfaces) {
			if (ic.getName().toLowerCase().equals(roleName.toLowerCase())) {
				return ic;
			}
		}
		return null;
	}

	protected void glue() {
	}
}
