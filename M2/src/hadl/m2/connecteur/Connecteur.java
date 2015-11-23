package hadl.m2.connecteur;

import hadl.m2.element.Element;
import hadl.m2.interfaces.InterfaceConnecteur;

import java.util.List;

public abstract class Connecteur extends Element {
	enum TypeConnecteur {
		implicite, explicite, enumeree;
	}

	enum Typologie {
		publique, prive;
	}

	public List<InterfaceConnecteur> listInterfaces;

	public void addInterface(InterfaceConnecteur ie) {
		listInterfaces.add(ie);
	}

	public void removeInterface(InterfaceConnecteur ie) {
		listInterfaces.remove(ie);
	}

}
