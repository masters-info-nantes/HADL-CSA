package hadl.m1.serveur.composants.connectionManager;

import hadl.m2.interfaces.ports.PortCptConfigRequis;

public class PortExternalSocketFrom extends PortCptConfigRequis {

	public PortExternalSocketFrom(String name) {
		super(name);
	}

    public void sendToConnexionManager(Object arg) {
    	System.out.print(this.getClass().getSimpleName()+" -> ");
        this.setChanged();
        this.notifyObservers(arg);
    }
}
