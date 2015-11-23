package alma.m2.connecteur;

import java.util.List;

import alma.m2.element.Element;
import alma.m2.interfaces.InterfaceConnecteur;

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
