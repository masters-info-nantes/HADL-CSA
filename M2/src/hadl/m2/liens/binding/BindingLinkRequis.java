package hadl.m2.liens.binding;

import hadl.m2.interfaces.ports.PortConfigRequis;
import hadl.m2.interfaces.ports.PortCptConfigRequis;

public class BindingLinkRequis implements Binding {
	protected PortConfigRequis portCfg;
	protected PortCptConfigRequis portCpt;

	public BindingLinkRequis(PortCptConfigRequis pcpt, PortConfigRequis pcfg) {
		portCfg = pcfg;
		portCpt = pcpt;

		System.out.println("Binding link created :" + portCfg.getName()
				+ "<-->" + portCpt.getName());
	}
}
