package hadl.m1.serveur.connecteurs.securityQuery;

import hadl.m2.connecteur.ConnecteurSimple;

public class SecurityQuery extends ConnecteurSimple {

	private RoleSmSqCalled roleSmSqCalled;
	private RoleSmSqCaller roleSmSqCaller;

	private RoleDbSqCalled roleDbSqCalled;
	private RoleDbSqCaller roleDbSqCaller;

	public SecurityQuery(String name) {
		super(name);

		roleSmSqCalled = new RoleSmSqCalled("roleSmSqCalled");
		roleSmSqCaller = new RoleSmSqCaller("roleSmSqCaller");

		roleDbSqCalled = new RoleDbSqCalled("roleDbSqCalled");
		roleDbSqCaller = new RoleDbSqCaller("roleDbSqCaller");

		addRole(roleSmSqCalled);
		addRole(roleSmSqCaller);

		addRole(roleDbSqCalled);
		addRole(roleDbSqCaller);
        this.glue();
	}

    public void glue() {
        System.out.println(this.getClass().getSimpleName()+" glue connecting  :"+ roleSmSqCaller.getName()+ " <---> "+ roleDbSqCalled.getName());
        roleDbSqCaller.addObserver(roleSmSqCalled);
        System.out.println(this.getClass().getSimpleName()+" glue connecting  :"+ roleDbSqCaller.getName()+ " <---> "+ roleSmSqCalled.getName()+"\n");
        roleSmSqCaller.addObserver(roleDbSqCalled);
    }
}
