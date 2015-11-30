package hadl.m1.serveur.bindings;

import hadl.m1.serveur.serveurComposant.PortServeurCptRequis;
import hadl.m1.serveur.serveurConfiguration.PortServeurConfigRequis;
import hadl.m2.liens.binding.BindingLinkRequis;

import java.util.Observable;
import java.util.Observer;

public class BindToServeurComposant extends BindingLinkRequis implements Observer {

	public BindToServeurComposant(PortServeurCptRequis portServeurComp,
                                  PortServeurConfigRequis portServeurConf) {

		super(portServeurComp, portServeurConf);
		this.portCptConfigRequis.addObserver(this);
	}

	public void update(Observable o, Object arg) {
		if (o instanceof PortServeurCptRequis) {
			this.portConfigRequis.post(arg);
		}

	}
}
