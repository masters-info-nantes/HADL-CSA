package hadl.m2.composant;

import hadl.m2.interfaces.InterfaceComposantConfig;

import java.util.ArrayList;
import java.util.List;

public class ComposantConfiguration extends Composant {

	private List<InterfaceComposantConfig> listInterfaces;
	protected String name;

	public ComposantConfiguration(String name) {
		this.name = name;
		this.listInterfaces = new ArrayList<InterfaceComposantConfig>();
	}

	public void addInterface(InterfaceComposantConfig ic) {
		this.listInterfaces.add(ic);
	}

	public InterfaceComposantConfig getInterfaceElement(String intefaceName) {
		for (InterfaceComposantConfig ifc : this.listInterfaces) {
			if (ifc.getName().toLowerCase().equals(intefaceName.toLowerCase())) {
				return ifc;
			}
		}
		return null;
	}
}
