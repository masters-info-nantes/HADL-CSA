package hadl.m1.connecteur;

import hadl.m2.interfaces.roles.RoleFourni;

import java.util.Observable;

public class RoleClientRpcCalled extends RoleFourni {

	public RoleClientRpcCalled(String name) {
		super(name);
	}

	public void update(Observable o, Object arg) {

		if (o instanceof RoleServerRpcCaller) {
			this.setChanged();
			this.notifyObservers(arg);
		}

	}

}
