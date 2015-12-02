package hadl.m1.serveur.connecteurs.securityQuery;

import hadl.m2.interfaces.roles.RoleRequis;

public class RoleSmSqCaller extends RoleRequis {

	public RoleSmSqCaller(String name) {
		super(name);
	}

	public void receiveFromSecurityManager(Object arg) {
		System.out.println(this.getClass().getSimpleName()+" -> SecurityQuery");
        setChanged();
        notifyObservers(arg);
    }
}
