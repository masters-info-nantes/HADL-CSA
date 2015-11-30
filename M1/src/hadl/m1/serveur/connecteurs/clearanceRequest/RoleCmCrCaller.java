package hadl.m1.serveur.connecteurs.clearanceRequest;

import hadl.m2.interfaces.roles.RoleRequis;

public class RoleCmCrCaller extends RoleRequis  {

	public RoleCmCrCaller(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

    public void sendRequest(Object arg) {
        setChanged();
        notifyObservers(arg);
    }


}
