package hadl.m1.serveur.connecteurs.clearanceRequest;

import hadl.m2.connecteur.ConnecteurSimple;

public class ClearanceRequest extends ConnecteurSimple  {

	private RoleCmCrCalled roleCmCrCalled;
	private RoleCmCrCaller roleCmCrCaller;

	private RoleSmCrCalled roleSmCrCalled;
	private RoleSmCrCaller roleSmCrCaller;

	public ClearanceRequest(String name) {
		super(name);

		roleCmCrCalled = new RoleCmCrCalled("roleCmCrCalled");
		roleCmCrCaller = new RoleCmCrCaller("roleCmCrCaller");

		roleSmCrCalled = new RoleSmCrCalled("roleSmCrCalled");
		roleSmCrCaller = new RoleSmCrCaller("roleSmCrCaller");

		addRole(roleCmCrCalled);
		addRole(roleCmCrCaller);

		addRole(roleSmCrCalled);
		addRole(roleSmCrCaller);


        this.glue();
	}
	
    public void glue () {
        System.out.println(this.getClass().getSimpleName()+" glue connection between : "+roleCmCrCalled.getName() +" and "+ roleSmCrCaller.getName() );
        roleCmCrCaller.addObserver(roleSmCrCalled);
        System.out.println(this.getClass().getSimpleName()+" glue connection between : "+roleSmCrCalled.getName() +" and "+ roleCmCrCaller.getName());
        roleSmCrCaller.addObserver(roleCmCrCalled);
    }


}
