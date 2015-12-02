package hadl.m1.serveur.composants.database;

import hadl.m2.interfaces.ports.PortCptConfigRequis;

public class PortQueryDatabaseFrom extends PortCptConfigRequis {

	public PortQueryDatabaseFrom(String name) {
		super(name);
	}

	public void receiveFromSqlQuery(Object arg) {
		System.out.print(this.getClass().getSimpleName()+" -> ");
		this.setChanged();
		this.notifyObservers(arg);
	}
}
