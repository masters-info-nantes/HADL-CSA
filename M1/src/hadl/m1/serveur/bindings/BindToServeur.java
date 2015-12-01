package hadl.m1.serveur.bindings;


import hadl.m1.serveur.composants.connectionManager.PortExternalSocketFrom;
import hadl.m1.serveur.serveurConfiguration.PortServeurRequis;
import hadl.m2.liens.binding.BindingLinkRequis;

import java.util.Observable;
import java.util.Observer;

public class BindToServeur extends BindingLinkRequis implements Observer {

	public BindToServeur(PortServeurRequis psr, PortExternalSocketFrom pesf) {
        super(pesf, psr);
        
        psr.addObserver(this);
    }


    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof PortServeurRequis) {
            ((PortExternalSocketFrom) portCptConfigRequis).sendToConnexionManager(arg);
        }
    }
}