package alma.m2.liens.binding;

import alma.m2.interfaces.ports.PortConfigFourni;
import alma.m2.interfaces.ports.PortCptConfigFourni;

public class BindingLinkFourni implements Binding {

	private PortConfigFourni portCfg;
	private PortCptConfigFourni portCpt;

	public BindingLinkFourni(PortConfigFourni pcfg, PortCptConfigFourni pcpt) {
		portCfg = pcfg;
		portCpt = pcpt;

		System.out.println("Binding link created :" + portCfg.getName()
				+ "<-->" + portCpt.getName());
	}
}
