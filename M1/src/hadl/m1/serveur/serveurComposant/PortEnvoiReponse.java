package hadl.m1.serveur.serveurComposant;

import hadl.m2.interfaces.ports.PortCptConfigFourni;

public class PortEnvoiReponse extends PortCptConfigFourni {

	public PortEnvoiReponse(String name) {
		super(name);
	}


    public void sendReponse(Object arg) {
    	System.out.print(this.getClass().getSimpleName()+" -> ");
        setChanged();
        notifyObservers(arg);
    }
}
