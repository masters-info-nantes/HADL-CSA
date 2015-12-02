package hadl.m1.serveur.connecteurs.sqlQuery;

import hadl.m2.interfaces.roles.RoleRequis;

public class RoleDbSQLqCaller extends RoleRequis {

	public RoleDbSQLqCaller(String name) {
		super(name);
	}

	public void receiveFromDatabase(Object arg) {
		System.out.println(this.getClass().getSimpleName()+" -> SQLQuery");
        setChanged();
        notifyObservers(arg);
    }

}
