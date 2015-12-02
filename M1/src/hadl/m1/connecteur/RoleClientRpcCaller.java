package hadl.m1.connecteur;

import hadl.m2.interfaces.roles.RoleRequis;

public class RoleClientRpcCaller extends RoleRequis {

	public RoleClientRpcCaller(String name) {
		super(name);

	}

	public void getRequete(Object arg) {
		System.out.println(this.getClass().getSimpleName()+ " -> RPC");
        this.setChanged();
		this.notifyObservers(arg);
	}

}
