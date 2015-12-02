package hadl.m1.serveur.connecteurs.clearanceRequest;

import hadl.m2.interfaces.roles.RoleFourni;

import java.util.Observable;
import java.util.Observer;

public class RoleCmCrCalled extends RoleFourni implements Observer {

	public RoleCmCrCalled(String name) {
		super(name);
	}

	@Override
	public void update(Observable o, Object arg) {

		if (o instanceof RoleSmCrCaller) {
			System.out.print("	< "+this.getClass().getSimpleName()+" -> ");
			setChanged();
			notifyObservers(arg);
		}
	}
}
