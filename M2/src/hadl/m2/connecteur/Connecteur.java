package hadl.m2.connecteur;

import hadl.m2.element.Element;
import hadl.m2.interfaces.InterfaceConnecteur;
import hadl.m2.interfaces.roles.Role;

public abstract class Connecteur extends Element {
	enum TypeConnecteur {
		implicite, explicite, enumeree;
	}

	enum Typologie {
		publique, prive;
	}

	protected String name;

	public InterfaceConnecteur interfaceConnecteur;

	public void addRole(Role ie) {
		interfaceConnecteur.add(ie);
	}

	public void removeRole(Role ie) {
		interfaceConnecteur.remove(ie);
	}

	public String getName() {
		return name;
	}

}
