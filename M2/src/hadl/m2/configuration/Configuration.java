package hadl.m2.configuration;

import hadl.m2.element.Element;
import hadl.m2.interfaces.InterfaceConfiguration;
import hadl.m2.interfaces.ports.PortConfiguration;

import java.util.ArrayList;
import java.util.List;

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

	public InterfaceConfiguration getInterface(String s) {

		for (InterfaceConfiguration ic : interfaceConfiguration.getPorts()) {
			if (ic.getName().toLowerCase().equals(s.toLowerCase()))
				return ic;
		}
		return null;
	}

	public String getName() {
		return name;
	}


    public List<Element> getListElement() {
        return ListElement;
    }
}
