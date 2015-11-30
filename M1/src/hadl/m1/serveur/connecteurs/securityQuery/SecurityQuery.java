package hadl.m1.serveur.connecteurs.securityQuery;

import java.util.Observable;
import java.util.Observer;

import hadl.m2.connecteur.ConnecteurSimple;

public class SecurityQuery extends ConnecteurSimple implements Observer {

	private RoleSmSqCalled roleSmSqCalled;
	private RoleSmSqCaller roleSmSqCaller;

	private RoleDbSqCalled roleDbSqCalled;
	private RoleDbSqCaller roleDbSqCaller;

	public SecurityQuery(String name) {
		super(name);

		roleSmSqCalled = new RoleSmSqCalled("roleSmSqCalled");
		roleSmSqCaller = new RoleSmSqCaller("roleSmSqCaller");

		roleDbSqCalled = new RoleDbSqCalled("roleDbSqCalled");
		roleDbSqCaller = new RoleDbSqCaller("roleDbSqCaller");

		addRole(roleSmSqCalled);
		addRole(roleSmSqCaller);

		addRole(roleDbSqCalled);
		addRole(roleDbSqCaller);

		roleSmSqCaller.addObserver(this);
		roleDbSqCaller.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}
}
