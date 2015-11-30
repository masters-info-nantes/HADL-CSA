package hadl.m1.serveur.connecteurs.sqlQuery;

import hadl.m2.interfaces.roles.RoleFourni;

import java.util.Observable;
import java.util.Observer;

public class RoleDbSQLqCalled extends RoleFourni implements Observer{

	public RoleDbSQLqCalled(String name) {
		super(name);
	}

	public void update(Observable o, Object arg) {
		
		if (o instanceof RoleCmSQLqCaller) {
            setChanged();
            notifyObservers(arg);
        }
	}

}
