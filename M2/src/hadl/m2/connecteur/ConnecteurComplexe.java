package hadl.m2.connecteur;

import java.util.ArrayList;
import java.util.List;

import hadl.m2.configuration.Configuration;
import hadl.m2.interfaces.InterfaceConnecteur;

public class ConnecteurComplexe extends Connecteur {

	public List<Configuration> listConfiguration;

	public ConnecteurComplexe() {
		super();

		this.listInterfaces = new ArrayList<InterfaceConnecteur>();
		this.listConfiguration = new ArrayList<Configuration>();
	}

	public void addConfiguration(Configuration c) {
		listConfiguration.add(c);
	}

}
