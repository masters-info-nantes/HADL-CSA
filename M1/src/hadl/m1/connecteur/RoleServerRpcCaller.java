package hadl.m1.connecteur;

import hadl.m2.interfaces.roles.RoleRequis;

public class RoleServerRpcCaller extends RoleRequis {

	public RoleServerRpcCaller(String name) {
		super(name);

	}


    public void getResponse(Object arg) {
    	System.out.println(this.getClass().getSimpleName()+" -> RPC");
        setChanged();
        notifyObservers(arg);
    }
}
