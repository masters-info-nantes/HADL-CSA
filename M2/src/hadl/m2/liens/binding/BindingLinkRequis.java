package hadl.m2.liens.binding;

import hadl.m2.interfaces.ports.PortConfigRequis;
import hadl.m2.interfaces.ports.PortCptConfigRequis;

public class BindingLinkRequis implements Binding {
	private PortConfigRequis portCfg;
	private PortCptConfigRequis portCpt;

	public BindingLinkRequis(PortConfigRequis pcfg, PortCptConfigRequis pcpt) {
		portCfg = pcfg;
		portCpt = pcpt;

		System.out.println("Binding link created :" + portCfg.getName()
				+ "<-->" + portCpt.getName());
	}
}
