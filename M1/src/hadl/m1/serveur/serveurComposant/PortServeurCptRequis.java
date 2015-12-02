package hadl.m1.serveur.serveurComposant;

import hadl.m2.interfaces.ports.PortCptConfigRequis;

public class PortServeurCptRequis extends PortCptConfigRequis {

	public PortServeurCptRequis(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

    public void sendRequest(Object arg) {
    	System.out.print(this.getClass().getSimpleName()+" -> ");
        setChanged();
        notifyObservers(arg);
    }

}
