package hadl.m2.interfaces;

import java.util.ArrayList;
import java.util.List;

import hadl.m2.interfaces.roles.Role;

public class InterfaceConnecteur extends Interface {
	private List<Role> roles;

	public InterfaceConnecteur() {
		super();
		roles = new ArrayList<Role>();
	}

	public void add(Role role) {
		roles.add(role);
	}

	public void remove(Role role) {
		roles.remove(role);
	}
}
