package hadl.m2.connecteur;

import hadl.m2.interfaces.InterfaceConnecteur;
import hadl.m2.interfaces.roles.Role;

public class ConnecteurSimple extends Connecteur {

	public ConnecteurSimple() {
        interfaceConnecteur = new InterfaceConnecteur();
	}

    public ConnecteurSimple(String name) {
        interfaceConnecteur = new InterfaceConnecteur();
        this.name = name;
    }


    protected void glue() {
	}

    public Role getRole(String rolename) {
        return interfaceConnecteur.getRole(rolename);
    }
}
