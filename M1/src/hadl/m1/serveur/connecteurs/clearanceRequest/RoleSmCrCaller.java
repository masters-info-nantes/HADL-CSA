package hadl.m1.serveur.connecteurs.clearanceRequest;

import hadl.m2.interfaces.roles.RoleRequis;

public class RoleSmCrCaller extends RoleRequis{

	public RoleSmCrCaller(String name) {
		super(name);
	}

	public void receiveFromSecurityManager(Object arg) {
		System.out.println(this.getClass().getSimpleName()+" -> ClearanceRequest");
        setChanged();
        notifyObservers(arg);
    }
}
