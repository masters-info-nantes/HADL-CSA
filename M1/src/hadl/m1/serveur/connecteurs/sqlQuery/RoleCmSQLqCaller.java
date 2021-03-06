package hadl.m1.serveur.connecteurs.sqlQuery;

import hadl.m2.interfaces.roles.RoleRequis;

public class RoleCmSQLqCaller extends RoleRequis {

	public RoleCmSQLqCaller(String name) {
		super(name);
	}

	public void receiveFromConnectionManager(Object arg) {
		System.out.println(this.getClass().getSimpleName()+" -> SQLQuery");
        setChanged();
        notifyObservers(arg);
    }
}
