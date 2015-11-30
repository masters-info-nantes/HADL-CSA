package hadl.m1.serveur.connecteurs.clearanceRequest;

import hadl.m2.interfaces.roles.RoleFourni;

import java.util.Observable;
import java.util.Observer;

public class RoleSmCrCalled extends RoleFourni implements Observer {

	public RoleSmCrCalled(String name) {
		super(name);
	}

	public void update(Observable o, Object arg) {
		
		if (o instanceof RoleCmCrCaller) {
            setChanged();
            notifyObservers(arg);
        }
	}

}
