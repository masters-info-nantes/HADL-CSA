package alma.m2.connecteur;

import java.util.ArrayList;
import java.util.List;

import alma.m2.configuration.Configuration;
import alma.m2.interfaces.InterfaceConnecteur;

public class ConnecteurComplexe extends Connecteur {

	public List<InterfaceConnecteur> listInterfaces;

	public List<Configuration> listConfiguration;

	public ConnecteurComplexe() {
		super();
		this.listInterfaces = new ArrayList<InterfaceConnecteur>();
		this.listConfiguration = new ArrayList<Configuration>();
	}

	public void addInterface(InterfaceConnecteur ie) {
		listInterfaces.add(ie);
	}

	public void addConfiguration(Configuration c) {
		listConfiguration.add(c);
	}

}
