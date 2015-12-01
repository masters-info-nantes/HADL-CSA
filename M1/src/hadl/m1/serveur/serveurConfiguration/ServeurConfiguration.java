package hadl.m1.serveur.serveurConfiguration;

import hadl.m1.serveur.attachments.*;
import hadl.m1.serveur.bindings.BindToConnectionManager;
import hadl.m1.serveur.bindings.BindToServeur;
import hadl.m1.serveur.composants.connectionManager.*;
import hadl.m1.serveur.composants.database.*;
import hadl.m1.serveur.composants.securityManager.SecurityManager;
import hadl.m1.serveur.composants.securityManager.*;
import hadl.m1.serveur.connecteurs.clearanceRequest.ClearanceRequest;
import hadl.m1.serveur.connecteurs.securityQuery.SecurityQuery;
import hadl.m1.serveur.connecteurs.sqlQuery.SQLQuery;
import hadl.m1.serveur.serveurComposant.PortServeurCptFourni;
import hadl.m1.serveur.serveurComposant.PortServeurCptRequis;
import hadl.m1.serveur.serveurComposant.ServeurComposant;
import hadl.m2.composant.ComposantConfiguration;
import hadl.m2.configuration.Configuration;
import hadl.m2.element.Element;
import hadl.m2.interfaces.ports.PortCptConfigFourni;
import hadl.m2.interfaces.ports.PortCptConfigRequis;
import hadl.m2.interfaces.roles.RoleFourni;
import hadl.m2.interfaces.roles.RoleRequis;
import hadl.m2.liens.binding.BindingLinkFourni;
import hadl.m2.liens.binding.BindingLinkRequis;

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

        //composition avec les composants
        ServeurComposant serveurComposant = new ServeurComposant("serveurComposant");
        Database database = new Database("database");
        ConnectionManager connectionManager = new ConnectionManager("connectionManager");
        SecurityManager securityManager = new SecurityManager("securityManager");

        //composition avec les connecteurs
        ClearanceRequest clearanceRequest = new ClearanceRequest("clearanceRequest");
        SQLQuery sqlQuery = new SQLQuery("sqlQuery");
        SecurityQuery securityQuery = new SecurityQuery("securityQuery");

        addElement(serveurComposant);
        addElement(database);
        addElement(connectionManager);
        addElement(securityManager);

        addElement(clearanceRequest);
        addElement(sqlQuery);
        addElement(securityQuery);

        /**
         * on récupère tous les services pour obtenir les instances des ports
         */

        //services from connexion manager

        ServiceExternalSocketFrom serviceExternalSocketFrom = (ServiceExternalSocketFrom) connectionManager.getInterfaceService("serviceExternalSocketFrom");
        ServiceExternalSocketTo serviceExternalSocketTo = (ServiceExternalSocketTo) connectionManager.getInterfaceService("serviceExternalSocketTo");

        ServiceSecurityCheckFrom serviceSecurityCheckFrom = (ServiceSecurityCheckFrom) connectionManager.getInterfaceService("serviceSecurityCheckFrom");
        ServiceSecurityCheckTo serviceSecurityCheckTo = (ServiceSecurityCheckTo) connectionManager.getInterfaceService("serviceSecurityCheckTo");

        ServiceDatabaseQueryTo serviceDatabaseQueryTo = (ServiceDatabaseQueryTo) connectionManager.getInterfaceService("serviceDatabaseQueryTo");
        ServiceDatabaseQueryFrom serviceDatabaseQueryFrom = (ServiceDatabaseQueryFrom) connectionManager.getInterfaceService("serviceDatabaseQueryFrom");

        //services from security manager

        ServiceSecurityAuthorizationFrom serviceSecurityAuthorizationFrom = (ServiceSecurityAuthorizationFrom) securityManager.getInterfaceService("ServiceSecurityAuthorizationFrom");
        ServiceSecurityAuthorizationTo serviceSecurityAuthorizationTo = (ServiceSecurityAuthorizationTo) securityManager.getInterfaceService("ServiceSecurityAuthorizationTo");

        ServiceChQueryFrom serviceChQueryFrom = (ServiceChQueryFrom) securityManager.getInterfaceService("ServiceChQueryFrom");
        ServiceChQueryTo serviceChQueryTo = (ServiceChQueryTo) securityManager.getInterfaceService("ServiceChQueryTo");


        //services from database

        ServiceQueryDatabaseFrom serviceQueryDatabaseFrom = (ServiceQueryDatabaseFrom) database.getInterfaceService("ServiceQueryDatabaseFrom");
        ServiceQueryDatabaseTo serviceQueryDatabaseTo = (ServiceQueryDatabaseTo) database.getInterfaceService("ServiceQueryDatabaseTo");
        ServiceSecurityManagementFrom serviceSecurityManagementFrom = (ServiceSecurityManagementFrom) database.getInterfaceService("ServiceSecurityManagementFrom");
        ServiceSecurityManagementTo serviceSecurityManagementTo = (ServiceSecurityManagementTo) database.getInterfaceService("ServiceSecurityManagementTo");

        /**
         * création des attachement
         */
        AttachmentSecurityCheckFrom attachmentSecurityCheckFrom  = new AttachmentSecurityCheckFrom((RoleFourni)clearanceRequest.getRole("rolecmcrcalled"), serviceSecurityCheckFrom.getPort("portsecuritycheckfrom"));
        AttachmentSecurityCheckTo attachmentSecurityCheckTo = new AttachmentSecurityCheckTo(serviceSecurityCheckTo.getPort("portsecuritycheckto"), (RoleRequis)clearanceRequest.getRole("cmcrcaller"));

        AttachmentChQueryFrom attachmentChQueryFrom = new AttachmentChQueryFrom((RoleFourni) securityQuery.getRole("RoleSmSqCalled"), (PortCptConfigRequis) securityManager.getInterfacePort("PortChQueryFrom"));
        AttachmentChQueryTo attachmentChQueryTo = new AttachmentChQueryTo((PortCptConfigFourni) securityManager.getInterfacePort("PortChQueryTo"), (RoleRequis) securityQuery.getRole("RoleSmSqCalled"));

        AttachmentDatabaseQueryFrom attachmentDatabaseQueryFrom = new AttachmentDatabaseQueryFrom((RoleFourni) sqlQuery.getRole("rolecmsqlqcalled") ,(PortCptConfigRequis)connectionManager.getInterfacePort("portDataBasequeryFrom") );
        AttachmentDatabaseQueryTo attachmentDatabaseQueryTo = new AttachmentDatabaseQueryTo((PortCptConfigFourni)connectionManager.getInterfacePort("portdatabasequeryto"), (RoleRequis)sqlQuery.getRole("rolecmsqlqcaller"));

        AttachmentQueryDatabaseFrom attachmentQueryDatabaseFrom = new AttachmentQueryDatabaseFrom((RoleFourni)sqlQuery.getRole("roledbsqlqcalled"), (PortCptConfigRequis)database.getInterfacePort("portqueryDatabasefrom"));
        AttachmentQueryDatabaseTo attachmentQueryDatabaseTo = new AttachmentQueryDatabaseTo((PortCptConfigFourni)database.getInterfacePort("portqueryDatabaseto"), (RoleRequis)sqlQuery.getRole("roledbsqlqcaller"));

        AttachmentSecurityAuthorizationFrom  attachmentSecurityAuthorizationFrom = new AttachmentSecurityAuthorizationFrom((RoleFourni)clearanceRequest.getRole("rolesmcrcaller"), (PortCptConfigRequis)securityManager.getInterfacePort("portsecurityauthorizationto"));
        AttachmentSecurityAuthorizationTo attachmentSecurityAuthorizationTo = new AttachmentSecurityAuthorizationTo((PortCptConfigFourni)securityManager.getInterfacePort("portsecurityauthorizationto"), (RoleRequis)clearanceRequest.getRole("rolesmcrcaller"));

        AttachmentSecurityManagementFrom attachmentSecurityManagementFrom = new AttachmentSecurityManagementFrom((RoleFourni)securityQuery.getRole("roledbsqlcalled"), (PortCptConfigRequis)database.getInterfacePort("portsecuritymanagementfrom"));
        AttachmentSecurityManagementTo attachmentSecurityManagementTo = new AttachmentSecurityManagementTo((PortCptConfigFourni)database.getInterfacePort("portsecuritymanagementfrom"), (RoleRequis)securityQuery.getRole("roledbsqlcalled"));

        /**
         * création des bindings
         */
        BindToConnectionManager bindToConnectionManager = new BindToConnectionManager((PortServeurFourni) this.getInterface("Portserveurrequis") , (PortExternalSocketTo) connectionManager.getInterfacePort("portexternalsocketfrom"));
        BindToServeur bindToServeur = new BindToServeur((PortServeurRequis) this.getInterface("portserveurrequis"), (PortExternalSocketFrom)connectionManager.getInterfacePort("PortExternalSocketFrom"));

        BindingLinkFourni bindingLinkFourni = new BindingLinkFourni((PortServeurConfigFourni)this.getInterface("PortServeurconfigFourni"), (PortServeurCptFourni) serveurComposant.getInterfacePort("PortServeurCptFourni"));
        BindingLinkRequis bindingLinkRequis = new BindingLinkRequis((PortServeurCptRequis) serveurComposant.getInterfacePort("PortServeurCptRequis"), (PortServeurConfigRequis)this.getInterface("PortServeurConfigRequis"));
    }

    @Override
    public void update(Observable o, Object arg) {

        if(o instanceof PortServeurFourni ) {

            ((PortServeurConfigFourni) getInterface("portServeurConfigFourni")).sendResponse(arg);

        }else if(o instanceof PortServeurConfigRequis) {

            ((PortServeurRequis) getInterface("PortServeurRequis")).sendToConnexionManager(arg);
        }
    }

    public ComposantConfiguration getElement(String name){

        for (Element e : getListElement()) {
            if (((ComposantConfiguration) e).getName().toLowerCase().equals(name)) {
                return (ComposantConfiguration) e;
            }
        }
        return null;
    }

}
