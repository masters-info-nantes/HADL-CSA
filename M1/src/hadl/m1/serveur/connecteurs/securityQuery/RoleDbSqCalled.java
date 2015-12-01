package hadl.m1.serveur.connecteurs.securityQuery;

import hadl.m2.interfaces.roles.RoleFourni;

import java.util.Observable;
import java.util.Observer;

public class RoleDbSqCalled extends RoleFourni implements Observer {

	public RoleDbSqCalled(String name) {
		super(name);
	}

	public void update(Observable o, Object arg) {

        if (o instanceof RoleSmSqCaller) {
            setChanged();
            notifyObservers(arg);
        }
	}

}
