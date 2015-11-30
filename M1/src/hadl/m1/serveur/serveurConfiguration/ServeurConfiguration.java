package hadl.m1.serveur.serveurConfiguration;

import hadl.m1.serveur.composants.connectionManager.ConnectionManager;
import hadl.m1.serveur.composants.database.Database;
import hadl.m1.serveur.composants.securityManager.SecurityManager;
import hadl.m2.configuration.Configuration;

import java.util.Observable;
import java.util.Observer;

public class ServeurConfiguration extends Configuration implements Observer {


	public ServeurConfiguration(String name) {
		super(name);

        PortServeurConfigFourni portServeurConfigFourni= new PortServeurConfigFourni("portConfigFourni");
        PortServeurConfigRequis portServeurConfigRequis= new PortServeurConfigRequis("portConfigRequis");

        PortServeurFourni portServeurFourni = new PortServeurFourni("portServeurFourni");
        PortServeurRequis portServeurRequis = new PortServeurRequis("portServeurRequis");


        addInterfaces(portServeurConfigFourni);
        addInterfaces(portServeurConfigRequis);
        addInterfaces(portServeurFourni);
        addInterfaces(portServeurRequis);

        portServeurConfigRequis.addObserver(this);
        portServeurRequis.addObserver(this);

        addElement(new Database("database"));
        addElement(new ConnectionManager("connexionManager"));
        addElement(new SecurityManager("securityManager"));

	}

    @Override
    public void update(Observable o, Object arg) {

            if(o instanceof PortServeurConfigRequis ) {
                ((PortServeurConfigFourni)getInterface("portServeurConfigFourni")).send(arg);

            }else if(o instanceof PortServeurRequis) {
                ((PortServeurFourni)getInterface("portServeurRequis")).send(arg);
            }
    }

}
