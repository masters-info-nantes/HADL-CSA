package hadl.m1.connecteur;

import hadl.m2.interfaces.roles.RoleFourni;

import java.util.Observable;

public class RoleServerRpcCalled extends RoleFourni {

    public RoleServerRpcCalled(String name) {
        super(name);
    }


    @Override
    public void update(Observable o, Object arg) {

        if (o instanceof RoleClientRpcCaller) {
        	System.out.print("	> "+this.getClass().getSimpleName()+" -> ");
            this.setChanged();
            this.notifyObservers(arg);
        }

    }
}
