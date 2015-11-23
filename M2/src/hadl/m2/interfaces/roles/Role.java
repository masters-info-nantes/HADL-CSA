package hadl.m2.interfaces.roles;

import hadl.m2.interfaces.InterfaceConnecteur;

public abstract class Role extends InterfaceConnecteur {
	protected String name;

	public String getName() {
		return name;
	}
}
