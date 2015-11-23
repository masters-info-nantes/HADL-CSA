package alma.m2.interfaces.roles;

import alma.m2.interfaces.InterfaceConnecteur;

public abstract class Role extends InterfaceConnecteur {
	private String name;

	public String getName() {
		return name;
	}
}
