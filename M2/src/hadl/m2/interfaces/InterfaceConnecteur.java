package hadl.m2.interfaces;

import hadl.m2.interfaces.roles.Role;

import java.util.ArrayList;
import java.util.List;

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

    public Role getRole(String roleName) {

        for (Role r: roles) {
            if(roleName.toLowerCase().equals(r.getName().toLowerCase())){

                return r;
            }
        }
        return null;
    }
}
