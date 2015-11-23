package hadl.m2.configuration;

import java.util.ArrayList;
import java.util.List;

import hadl.m2.element.Element;
import hadl.m2.interfaces.InterfaceConfiguration;

public class Configuration extends Element {

	private List<Element> ListElement;
	private List<InterfaceConfiguration> listInterfaces;
	private String name;

	public Configuration(String name) {

		this.ListElement = new ArrayList<Element>();
		this.listInterfaces = new ArrayList<InterfaceConfiguration>();
		this.name = name;
	}

	public void addElement(Element e) {
		ListElement.add(e);
	}

	public void addInterfaces(InterfaceConfiguration ic) {
		listInterfaces.add(ic);
	}

}
