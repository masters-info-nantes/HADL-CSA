package hadl.m1.serveur.serveurConfiguration;

import hadl.m2.interfaces.ports.PortConfigRequis;

public class PortServeurConfigRequis extends PortConfigRequis {

    public PortServeurConfigRequis(String name) {
        super(name);
    }


    public void sendRequest(Object arg) {
    	System.out.println(this.getClass().getSimpleName()+" -> Serveur");
        setChanged();
        notifyObservers(arg);
    }
}
