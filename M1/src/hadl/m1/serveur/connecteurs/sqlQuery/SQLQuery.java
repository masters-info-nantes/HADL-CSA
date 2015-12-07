package hadl.m1.serveur.connecteurs.sqlQuery;

import hadl.m2.connecteur.ConnecteurSimple;

public class SQLQuery extends ConnecteurSimple {

    private RoleCmSQLqCalled roleCmSQLqCalled;
    private RoleCmSQLqCaller roleCmSQLqCaller;

    private RoleDbSQLqCalled roleDbSQLqCalled;
    private RoleDbSQLqCaller roleDbSQLqCaller;

    public SQLQuery(String name) {
        super(name);

        roleCmSQLqCalled = new RoleCmSQLqCalled("roleCmSQLqCalled");
        roleCmSQLqCaller = new RoleCmSQLqCaller("roleCmSQLqCaller");

        roleDbSQLqCalled = new RoleDbSQLqCalled("roleDbSQLqCalled");
        roleDbSQLqCaller = new RoleDbSQLqCaller("roleDbSQLqCaller");

        addRole(roleCmSQLqCalled);
        addRole(roleCmSQLqCaller);

        addRole(roleDbSQLqCalled);
        addRole(roleDbSQLqCaller);
        this.glue();
    }

    public void glue() {
        System.out.println(this.getClass().getSimpleName()+" glue connecting  :"+ roleDbSQLqCaller.getName()+ " <---> "+ roleCmSQLqCalled.getName());
        roleDbSQLqCaller.addObserver(roleCmSQLqCalled);
        System.out.println(this.getClass().getSimpleName()+" glue connecting  :"+ roleCmSQLqCaller.getName()+ " <---> "+ roleDbSQLqCalled.getName()+"\n");
        roleCmSQLqCaller.addObserver(roleDbSQLqCalled);
    }

}
