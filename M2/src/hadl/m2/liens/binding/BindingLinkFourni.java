package hadl.m2.liens.binding;

import hadl.m2.interfaces.ports.PortConfigFourni;
import hadl.m2.interfaces.ports.PortCptConfigFourni;

public class BindingLinkFourni implements Binding {

	protected PortConfigFourni portConfigFourni;
	protected PortCptConfigFourni portCptConfigFourni;

	public BindingLinkFourni(PortConfigFourni pcfg, PortCptConfigFourni pcpt) {
		portConfigFourni = pcfg;
		portCptConfigFourni = pcpt;

		System.out.println("Binding link created : " + portCptConfigFourni.getName()
				+ " <--> " + portConfigFourni.getName());
	}
}
