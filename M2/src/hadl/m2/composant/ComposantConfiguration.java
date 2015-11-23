package hadl.m2.composant;

import java.util.ArrayList;
import java.util.List;

import hadl.m2.interfaces.InterfaceComposantConfig;

public class ComposantConfiguration extends Composant {

	private List<InterfaceComposantConfig> listInterfaces;
	private String name;

	public ComposantConfiguration(String name) {
		this.name = name;
		this.listInterfaces = new ArrayList<InterfaceComposantConfig>();
	}

	public void addInterface(InterfaceComposantConfig ic) {
		this.listInterfaces.add(ic);
	}
}
