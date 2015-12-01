package hadl.m1.serveur.bindings;

import hadl.m1.serveur.serveurComposant.PortServeurCptFourni;
import hadl.m1.serveur.serveurConfiguration.PortServeurConfigFourni;
import hadl.m2.liens.binding.BindingLinkFourni;

import java.util.Observable;
import java.util.Observer;

public class BindToServeurConfig extends BindingLinkFourni implements Observer {

	public BindToServeurConfig(PortServeurCptFourni portServeurComp, PortServeurConfigFourni portServeurConf) {

		super(portServeurConf, portServeurComp);
		this.portConfigFourni.addObserver(this);
	}

	public void update(Observable o, Object arg) {

		if (o instanceof PortServeurConfigFourni) {
            ((PortServeurCptFourni) this.portCptConfigFourni).sendRequest(arg);
		}

	}
}
