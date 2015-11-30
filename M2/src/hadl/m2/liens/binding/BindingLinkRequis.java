package hadl.m2.liens.binding;

import hadl.m2.interfaces.ports.PortConfigRequis;
import hadl.m2.interfaces.ports.PortCptConfigRequis;

public class BindingLinkRequis implements Binding {
	protected PortConfigRequis portConfigRequis;
	protected PortCptConfigRequis portCptConfigRequis;

	public BindingLinkRequis(PortCptConfigRequis portCptConfigRequis, PortConfigRequis portConfigRequis) {
		this.portConfigRequis = portConfigRequis;
		this.portCptConfigRequis = portCptConfigRequis;

		System.out.println("Binding link created :" + portConfigRequis.getName()
				+ "<-->" + portCptConfigRequis.getName());
	}
}
