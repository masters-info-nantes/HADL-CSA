package hadl.m1.serveur.composants.database;

import hadl.m2.interfaces.ports.PortCptConfigFourni;

public class PortQueryDatabaseTo extends PortCptConfigFourni {

	public PortQueryDatabaseTo(String name) {
		super(name);
	}

	public void sendToSqlQuery(Object arg) {
		System.out.print(this.getClass().getSimpleName()+" -> ");
        this.setChanged();
        this.notifyObservers(arg);
	}
}
