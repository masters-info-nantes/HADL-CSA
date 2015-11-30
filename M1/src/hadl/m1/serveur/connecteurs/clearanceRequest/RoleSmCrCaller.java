package hadl.m1.serveur.connecteurs.clearanceRequest;

import hadl.m2.interfaces.roles.RoleRequis;

import java.util.Observable;
import java.util.Observer;

public class RoleSmCrCaller extends RoleRequis implements Observer {

	public RoleSmCrCaller(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

    @Override
    public void update(Observable o, Object arg) {

    }
}
