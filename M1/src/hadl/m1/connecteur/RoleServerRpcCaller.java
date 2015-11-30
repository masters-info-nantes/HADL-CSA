package hadl.m1.connecteur;

import hadl.m2.interfaces.roles.RoleRequis;

public class RoleServerRpcCaller extends RoleRequis {

	public RoleServerRpcCaller(String name) {
		super(name);

	}

	public void get(Object arg) {
		this.setChanged();
		this.notifyObservers(arg);
	}

}
