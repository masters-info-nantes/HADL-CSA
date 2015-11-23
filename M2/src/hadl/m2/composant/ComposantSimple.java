package hadl.m2.composant;

import hadl.m2.interfaces.InterfaceComposantSimple;

import java.util.ArrayList;
import java.util.List;


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
