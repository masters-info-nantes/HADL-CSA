package hadl.m1.serveur.connecteurs.clearanceRequest;

import java.util.Observable;
import java.util.Observer;

import hadl.m2.connecteur.ConnecteurSimple;

public class ClearanceRequest extends ConnecteurSimple implements Observer {

	private RoleCmCrCalled roleCmCrCalled;
	private RoleCmCrCaller roleCmCrCaller;

	private RoleSmCrCalled roleSmCrCalled;
	private RoleSmCrCaller roleSmCrCaller;

	public ClearanceRequest(String name) {
		super(name);

		roleCmCrCalled = new RoleCmCrCalled("roleCmCrCalled");
		roleCmCrCaller = new RoleCmCrCaller("roleCmCrCaller");

		roleSmCrCalled = new RoleSmCrCalled("roleSmCrCalled");
		roleSmCrCaller = new RoleSmCrCaller("roleSmCrCaller");

		addRole(roleCmCrCalled);
		addRole(roleCmCrCaller);

		addRole(roleSmCrCalled);
		addRole(roleSmCrCaller);

		roleCmCrCaller.addObserver(this);
		roleSmCrCaller.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}


}
