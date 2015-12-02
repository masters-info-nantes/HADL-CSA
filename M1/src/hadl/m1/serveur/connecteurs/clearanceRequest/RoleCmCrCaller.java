package hadl.m1.serveur.connecteurs.clearanceRequest;

import hadl.m2.interfaces.roles.RoleRequis;

public class RoleCmCrCaller extends RoleRequis  {

	public RoleCmCrCaller(String name) {
		super(name);
	}
	
	public void receiveFromConnectionManager(Object arg) {
		System.out.println(this.getClass().getSimpleName()+" -> ClearanceRequest");
        setChanged();
        notifyObservers(arg);
    }
}
