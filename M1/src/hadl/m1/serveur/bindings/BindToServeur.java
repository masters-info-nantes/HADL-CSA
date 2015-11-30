package hadl.m1.serveur.bindings;

import hadl.m1.serveur.composants.connectionManager.PortExternalSocketTo;
import hadl.m1.serveur.serveurConfiguration.PortServeurFourni;
import hadl.m2.liens.binding.BindingLinkFourni;

import java.util.Observable;
import java.util.Observer;

public class BindToServeur extends BindingLinkFourni implements Observer {

	public BindToServeur(PortServeurFourni pcfg, PortExternalSocketTo pcpt) {
        super(pcfg, pcpt);
        pcpt.addObserver(this);
    }


    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof PortExternalSocketTo) {
            ((PortServeurFourni)portConfigFourni).sendResponse(arg);
        }
    }
}