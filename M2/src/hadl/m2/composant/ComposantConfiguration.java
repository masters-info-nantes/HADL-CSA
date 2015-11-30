package hadl.m2.composant;

import hadl.m2.interfaces.InterfaceComposantConfig;
import hadl.m2.interfaces.services.ServiceCptConfig;

public class ComposantConfiguration extends Composant {

	private InterfaceComposantConfig interfaceComposantConfig;
	protected String name;

	public ComposantConfiguration(String name) {
		this.name = name;
		interfaceComposantConfig = new InterfaceComposantConfig();
	}

	public void addService(ServiceCptConfig ic) {
		interfaceComposantConfig.addService(ic);
	}

	public void removeService(ServiceCptConfig ic) {
		interfaceComposantConfig.removeService(ic);
	}

	public InterfaceComposantConfig getInterfaceElement(String intefaceName) {
		for (InterfaceComposantConfig ifc : interfaceComposantConfig.getServices()) {
			if (ifc.getName().toLowerCase().equals(intefaceName.toLowerCase()))
				return ifc;
		}
		return null;
	}
}
