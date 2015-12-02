package hadl.m1.serveur.composants.connectionManager;

import hadl.m2.interfaces.ports.PortCptConfigRequis;

public class PortDatabaseQueryFrom extends PortCptConfigRequis {

	public PortDatabaseQueryFrom(String name) {
		super(name);
	}

	public void receiveFromSqlQuery(Object arg) {
		System.out.print(this.getClass().getSimpleName()+" -> ");
        this.setChanged();
        this.notifyObservers(arg);
    }
}
