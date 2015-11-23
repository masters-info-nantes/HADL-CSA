package hadl.m1.connecteur;

import hadl.m2.interfaces.roles.RoleRequis;

public class RoleClientRpcCaller extends RoleRequis {

	public RoleClientRpcCaller(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void get(Object arg) {
		this.setChanged();
		this.notifyObservers(arg);
	}

}
