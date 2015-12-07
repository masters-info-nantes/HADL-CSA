package hadl.m2.configuration;

import java.util.ArrayList;
import java.util.List;

import hadl.m2.element.Element;
import hadl.m2.interfaces.InterfaceConfiguration;
import hadl.m2.interfaces.ports.PortConfiguration;

public class Configuration extends Element {

	private List<Element> ListElement;
	private InterfaceConfiguration interfaceConfiguration;
	private String name;

	public Configuration(String name) {

		ListElement = new ArrayList<Element>();
		interfaceConfiguration = new InterfaceConfiguration();
		this.name = name;
	}

	public void addElement(Element e) {
		ListElement.add(e);
	}

	public void addInterfaces(PortConfiguration ic) {
		interfaceConfiguration.addPort(ic);
	}

	public PortConfiguration getInterface(String s) {

		for (PortConfiguration ic : interfaceConfiguration.getPorts()) {
			if (ic.getName().toLowerCase().equals(s.toLowerCase()))
				return ic;
		}
		return null;
	}

	@Override
	public String getName() {
		return name;
	}

	public List<Element> getListElement() {
		return ListElement;
	}
}
