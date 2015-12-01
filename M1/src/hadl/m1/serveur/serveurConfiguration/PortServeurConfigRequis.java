package hadl.m1.serveur.serveurConfiguration;

import hadl.m2.interfaces.ports.PortConfigRequis;

public class PortServeurConfigRequis extends PortConfigRequis {

    public PortServeurConfigRequis(String name) {
        super(name);
        // TODO Auto-generated constructor stub
    }


    public void sendRequest(Object arg) {
        setChanged();
        notifyObservers(arg);
    }
}
