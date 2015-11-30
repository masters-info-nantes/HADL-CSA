package hadl.m1.serveur.composants.database;

import hadl.m2.composant.ComposantConfiguration;

import java.util.Observable;
import java.util.Observer;

public class Database extends ComposantConfiguration implements Observer {

    public Database(String name) {
        super(name);

        ServiceQueryDatabaseFrom serviceQueryDatabaseFrom = new ServiceQueryDatabaseFrom("serviceQueryDatabaseFrom");
        ServiceQueryDatabaseTo serviceQueryDatabaseTo = new ServiceQueryDatabaseTo("serviceQueryDatabaseTo");

        serviceQueryDatabaseFrom.addObserver(this);

        ServiceSecurityManagementFrom serviceSecurityManagementFrom = new ServiceSecurityManagementFrom("serviceSecurityManagementFrom");
        ServiceSecurityManagementTo serviceSecurityManagementTo = new ServiceSecurityManagementTo("serviceSecurityManagementTo");

        serviceSecurityManagementFrom.addObserver(this);

        addService(serviceQueryDatabaseTo);
        addService(serviceQueryDatabaseFrom);
        addService(serviceSecurityManagementFrom);
        addService(serviceSecurityManagementTo);
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
