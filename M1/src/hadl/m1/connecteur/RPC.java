package hadl.m1.connecteur;

import hadl.m2.connecteur.ConnecteurSimple;

public class RPC extends ConnecteurSimple {

	private RoleClientRpcCalled roleClientRpcCalled;
	private RoleClientRpcCaller roleClientRpcCaller;
	private RoleServerRpcCalled roleServerRpcCalled;
	private RoleServerRpcCaller roleServerRpcCaller;

	public RPC() {
		this.roleClientRpcCalled = new RoleClientRpcCalled(
				"roleClientRpcCalled");
		this.roleClientRpcCaller = new RoleClientRpcCaller(
				"roleClientRpcCaller");
		this.roleServerRpcCalled = new RoleServerRpcCalled(
				"roleServerRpcCalled");
		this.roleServerRpcCaller = new RoleServerRpcCaller(
				"roleServerRpcCaller");

		this.addRole(roleClientRpcCalled);
		this.addRole(roleClientRpcCaller);
		this.addRole(roleServerRpcCalled);
		this.addRole(roleServerRpcCaller);
	}

	public void glue() {
		System.out
				.println("\t Rpc glue connecting roleClientRpcCaller <---> roleServerRpcCalled");
		this.roleClientRpcCaller.addObserver(this.roleServerRpcCalled);
		System.out
				.println("\t Rpc glue connecting roleServerRpcCaller <----> roleClientRpcCalled");
		this.roleServerRpcCaller.addObserver(this.roleClientRpcCalled);

	}
}
