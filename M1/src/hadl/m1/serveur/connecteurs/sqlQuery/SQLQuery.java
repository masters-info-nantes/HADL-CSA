package hadl.m1.serveur.connecteurs.sqlQuery;

import java.util.Observable;
import java.util.Observer;

import hadl.m2.connecteur.ConnecteurSimple;

public class SQLQuery extends ConnecteurSimple implements Observer {

	private RoleCmSQLqCalled roleCmSQLqCalled;
	private RoleCmSQLqCaller roleCmSQLqCaller;

	private RoleDbSQLqCalled roleDbSQLqCalled;
	private RoleDbSQLqCaller roleDbSQLqCaller;

	public SQLQuery(String name) {
		super(name);

		roleCmSQLqCalled = new RoleCmSQLqCalled("roleCmSQLqCalled");
		roleCmSQLqCaller = new RoleCmSQLqCaller("roleCmSQLqCaller");

		roleDbSQLqCalled = new RoleDbSQLqCalled("roleDbSQLqCalled");
		roleDbSQLqCaller = new RoleDbSQLqCaller("roleDbSQLqCaller");

		addRole(roleCmSQLqCalled);
		addRole(roleCmSQLqCaller);

		addRole(roleDbSQLqCalled);
		addRole(roleDbSQLqCaller);

		roleCmSQLqCaller.addObserver(this);
		roleDbSQLqCaller.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}
}
