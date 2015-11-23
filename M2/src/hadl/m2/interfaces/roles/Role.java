package hadl.m2.interfaces.roles;

import hadl.m2.interfaces.InterfaceConnecteur;

public abstract class Role extends InterfaceConnecteur {
	private String name;

	public String getName() {
		return name;
	}
}
