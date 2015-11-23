package alma.m2.composant;

import java.util.ArrayList;
import java.util.List;

import alma.m2.interfaces.InterfaceComposantSimple;

public class ComposantSimple extends Composant {

	private List<InterfaceComposantSimple> listInterfaces;
	private String name;

	public ComposantSimple(String name) {
		this.listInterfaces = new ArrayList<InterfaceComposantSimple>();
	}

	public void addListInterfaces(InterfaceComposantSimple ic) {
		this.listInterfaces.add(ic);
	}

}
