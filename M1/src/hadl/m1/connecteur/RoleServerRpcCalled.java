package hadl.m1.connecteur;

import hadl.m2.interfaces.roles.RoleFourni;

import java.util.Observable;

public class RoleServerRpcCalled extends RoleFourni {

	public RoleServerRpcCalled(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public void update(Observable o, Object arg) {
		if (o instanceof RoleClientRpcCaller) {
			this.setChanged();
			this.notifyObservers(arg);
		}
	}
}
