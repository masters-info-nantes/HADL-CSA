package hadl.m1.serveur.serveurConfiguration;

import hadl.m2.interfaces.ports.PortConfigFourni;

public class PortServeurFourni extends PortConfigFourni {

	public PortServeurFourni(String name) {
		super(name);
	}


    public void sendToServeur(Object arg) {
    	System.out.println(this.getClass().getSimpleName()+" -> Serveur");
        setChanged();
        notifyObservers(arg);
    }
}
