package hadl.m1.connecteur;

import hadl.m2.interfaces.roles.RoleRequis;

public class RoleClientRpcCaller extends RoleRequis {

	public RoleClientRpcCaller(String name) {
		super(name);

	}

	public void getRequete(Object arg) {
		this.setChanged();
		this.notifyObservers(arg);
	}

}
