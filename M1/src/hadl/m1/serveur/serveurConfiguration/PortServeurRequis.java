package hadl.m1.serveur.serveurConfiguration;

import hadl.m2.interfaces.ports.PortConfigRequis;

public class PortServeurRequis extends PortConfigRequis {

	public PortServeurRequis(String name) {
		super(name);
	}


    public void sendToConnexionManager(Object arg) {
    	System.out.print("	> "+this.getClass().getSimpleName()+" -> ");
        setChanged();
        notifyObservers(arg);
    }
}
