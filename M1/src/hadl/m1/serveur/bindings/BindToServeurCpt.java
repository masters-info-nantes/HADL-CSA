package hadl.m1.serveur.bindings;

import hadl.m1.serveur.serveurComposant.PortServeurCptRequis;
import hadl.m1.serveur.serveurConfiguration.PortServeurConfigRequis;
import hadl.m2.liens.binding.BindingLinkRequis;

import java.util.Observable;
import java.util.Observer;

public class BindToServeurCpt extends BindingLinkRequis implements Observer {

	public BindToServeurCpt(PortServeurConfigRequis pcfg, PortServeurCptRequis pcpt) {
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
