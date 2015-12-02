package hadl.m1.serveur.connecteurs.securityQuery;

import hadl.m2.interfaces.roles.RoleFourni;

import java.util.Observable;
import java.util.Observer;

public class RoleSmSqCalled extends RoleFourni implements Observer {

	public RoleSmSqCalled(String name) {
		super(name);
	}

	public void update(Observable o, Object arg) {

		if (o instanceof RoleDbSqCaller) {
			System.out.print("	< "+this.getClass().getSimpleName()+" -> ");
            setChanged();
            notifyObservers(arg);
        }
	}

}
