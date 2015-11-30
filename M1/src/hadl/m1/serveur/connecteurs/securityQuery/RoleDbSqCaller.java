package hadl.m1.serveur.connecteurs.securityQuery;

import hadl.m2.interfaces.roles.RoleRequis;

public class RoleDbSqCaller extends RoleRequis {

	public RoleDbSqCaller(String name) {
		super(name);
	}

	public void receiveFromDatabase(Object arg) {
        setChanged();
        notifyObservers(arg);
    }
}
