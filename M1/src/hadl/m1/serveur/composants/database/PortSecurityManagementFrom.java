package hadl.m1.serveur.composants.database;

import hadl.m2.interfaces.ports.PortCptConfigRequis;

public class PortSecurityManagementFrom extends PortCptConfigRequis {

	public PortSecurityManagementFrom(String name) {
		super(name);
	}

	public void receiveFromSecurityQuery(Object arg) {
		System.out.print(this.getClass().getSimpleName()+" -> ");
        this.setChanged();
		this.notifyObservers(arg);
	}
}
