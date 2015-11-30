package hadl.m1.serveur.bindings;

import hadl.m2.interfaces.ports.PortConfigFourni;
import hadl.m2.interfaces.ports.PortCptConfigFourni;
import hadl.m2.liens.binding.BindingLinkFourni;

public class BindToServeurConfig extends BindingLinkFourni {

	public BindToServeurConfig(PortConfigFourni pcfg, PortCptConfigFourni pcpt) {
		super(pcfg, pcpt);
	}

}
