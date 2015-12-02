package hadl.m1.serveur.composants.database;

import hadl.m2.interfaces.ports.PortCptConfigFourni;

public class PortSecurityManagementTo extends PortCptConfigFourni {

	public PortSecurityManagementTo(String name) {
		super(name);
	}

	public void sendToSecurityQuery(Object arg) {
		System.out.print(this.getClass().getSimpleName()+" -> ");
        this.setChanged();
        this.notifyObservers(arg);
    }
}
