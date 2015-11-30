package hadl.m2.composant;

import hadl.m2.interfaces.InterfaceComposantSimple;
import hadl.m2.interfaces.services.ServiceSimple;

public class ComposantSimple extends Composant {

	private InterfaceComposantSimple interfaceComposantSimple;
	private String name;

	public ComposantSimple(String name) {
		interfaceComposantSimple = new InterfaceComposantSimple();
	}

	public void addService(ServiceSimple ic) {
		interfaceComposantSimple.addService(ic);
	}

	public void removeService(ServiceSimple ic) {
		interfaceComposantSimple.removeService(ic);
	}

	public String getName() {
		return name;
	}
}
