package hadl.m1.serveur.connecteurs.sqlQuery;

import hadl.m2.interfaces.roles.RoleFourni;

import java.util.Observable;
import java.util.Observer;

public class RoleCmSQLqCalled extends RoleFourni implements Observer {

	public RoleCmSQLqCalled(String name) {
		super(name);
	}

	public void update(Observable o, Object arg) {
		
		if (o instanceof RoleDbSQLqCaller) {
            setChanged();
            notifyObservers(arg);
        }
	}

}
