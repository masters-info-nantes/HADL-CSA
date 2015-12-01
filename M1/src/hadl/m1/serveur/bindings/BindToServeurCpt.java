package hadl.m1.serveur.bindings;

import hadl.m1.serveur.serveurComposant.PortServeurCptRequis;
import hadl.m1.serveur.serveurConfiguration.PortServeurConfigRequis;
import hadl.m2.interfaces.ports.PortConfigRequis;
import hadl.m2.interfaces.ports.PortCptConfigRequis;
import hadl.m2.liens.binding.BindingLinkRequis;

import java.util.Observable;
import java.util.Observer;

public class BindToServeurCpt extends BindingLinkRequis implements Observer {

	public BindToServeurCpt(PortConfigRequis pcfg, PortCptConfigRequis pcpt) {
		super(pcpt, pcfg);
		
        this.portCptConfigRequis.addObserver(this);
	}

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof PortServeurCptRequis) {
        	((PortServeurConfigRequis) portConfigRequis).sendRequest(arg);
        }
    }
}
