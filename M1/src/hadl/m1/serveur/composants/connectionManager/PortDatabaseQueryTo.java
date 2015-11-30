package hadl.m1.serveur.composants.connectionManager;

import hadl.m2.interfaces.ports.PortCptConfigFourni;

public class PortDatabaseQueryTo extends PortCptConfigFourni {

	public PortDatabaseQueryTo(String name) {
		super(name);
	}
	
	public void sendToSqlQuery(Object arg) {
		this.setChanged();
		this.notifyObservers(arg);
    }

}
