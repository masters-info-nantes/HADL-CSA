package hadl.m1.serveur.serveurConfiguration;

import hadl.m1.serveur.attachments.*;
import hadl.m1.serveur.bindings.BindToConnectionManager;
import hadl.m1.serveur.bindings.BindToServeur;
import hadl.m1.serveur.composants.connectionManager.ConnectionManager;
import hadl.m1.serveur.composants.connectionManager.PortExternalSocketFrom;
import hadl.m1.serveur.composants.connectionManager.PortExternalSocketTo;
import hadl.m1.serveur.composants.database.Database;
import hadl.m1.serveur.composants.securityManager.SecurityManager;
import hadl.m1.serveur.connecteurs.clearanceRequest.ClearanceRequest;
import hadl.m1.serveur.connecteurs.securityQuery.SecurityQuery;
import hadl.m1.serveur.connecteurs.sqlQuery.SQLQuery;
import hadl.m1.serveur.serveurComposant.PortServeurCptFourni;
import hadl.m1.serveur.serveurComposant.PortServeurCptRequis;
import hadl.m1.serveur.serveurComposant.ServeurComposant;
import hadl.m2.configuration.Configuration;
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

        AttachmentSecurityCheckFrom attachmentSecurityCheckFrom  = new AttachmentSecurityCheckFrom((RoleFourni)clearanceRequest.getRole("rolecmcrcalled"), (PortCptConfigRequis)connectionManager.getInterfaceElement("portsecuritycheckfrom"));
        AttachmentSecurityCheckTo attachmentSecurityCheckTo = new AttachmentSecurityCheckTo((PortCptConfigFourni)connectionManager.getInterfaceElement("portsecuritycheckto"), (RoleRequis)clearanceRequest.getRole("cmcrcaller"));

        AttachmentChQueryFrom attachmentChQueryFrom = new AttachmentChQueryFrom((RoleFourni) securityQuery.getRole("RoleSmSqCalled"), (PortCptConfigRequis) securityManager.getInterfaceElement("PortChQueryFrom"));
        AttachmentChQueryTo attachmentChQueryTo = new AttachmentChQueryTo((PortCptConfigFourni) securityManager.getInterfaceElement("PortChQueryTo"), (RoleRequis) securityQuery.getRole("RoleSmSqCalled"));

        AttachmentDatabaseQueryFrom attachmentDatabaseQueryFrom = new AttachmentDatabaseQueryFrom((RoleFourni) sqlQuery.getRole("rolecmsqlqcalled") ,(PortCptConfigRequis)connectionManager.getInterfaceElement("portDataBasequeryFrom") );
        AttachmentDatabaseQueryTo attachmentDatabaseQueryTo = new AttachmentDatabaseQueryTo((PortCptConfigFourni)connectionManager.getInterfaceElement("portdatabasequeryto"), (RoleRequis)sqlQuery.getRole("rolecmsqlqcaller"));

        AttachmentQueryDatabaseFrom attachmentQueryDatabaseFrom = new AttachmentQueryDatabaseFrom((RoleFourni)sqlQuery.getRole("roledbsqlqcalled"), (PortCptConfigRequis)database.getInterfaceElement("portqueryDatabasefrom"));
        AttachmentQueryDatabaseTo attachmentQueryDatabaseTo = new AttachmentQueryDatabaseTo((PortCptConfigFourni)database.getInterfaceElement("portqueryDatabaseto"), (RoleRequis)sqlQuery.getRole("roledbsqlqcaller"));

        AttachmentSecurityAuthorizationFrom  attachmentSecurityAuthorizationFrom = new AttachmentSecurityAuthorizationFrom((RoleFourni)clearanceRequest.getRole("rolesmcrcaller"), (PortCptConfigRequis)securityManager.getInterfaceElement("portsecurityauthorizationto"));
        AttachmentSecurityAuthorizationTo attachmentSecurityAuthorizationTo = new AttachmentSecurityAuthorizationTo((PortCptConfigFourni)securityManager.getInterfaceElement("portsecurityauthorizationto"), (RoleRequis)clearanceRequest.getRole("rolesmcrcaller"));

        AttachmentSecurityManagementFrom attachmentSecurityManagementFrom = new AttachmentSecurityManagementFrom((RoleFourni)securityQuery.getRole("roledbsqlcalled"), (PortCptConfigRequis)database.getInterfaceElement("portsecuritymanagementfrom"));
        AttachmentSecurityManagementTo attachmentSecurityManagementTo = new AttachmentSecurityManagementTo((PortCptConfigFourni)database.getInterfaceElement("portsecuritymanagementfrom"), (RoleRequis)securityQuery.getRole("roledbsqlcalled"));

        BindToConnectionManager bindToConnectionManager = new BindToConnectionManager((PortServeurFourni) this.getInterface("Portserveurrequis") , (PortExternalSocketTo) connectionManager.getInterfaceElement("portexternalsocketfrom"));
        BindToServeur bindToServeur = new BindToServeur((PortServeurRequis) this.getInterface("portserveurrequis"), (PortExternalSocketFrom)connectionManager.getInterfaceElement(""));

        BindingLinkFourni bindingLinkFourni = new BindingLinkFourni((PortServeurConfigFourni)this.getInterface("PortServeurconfigFourni"), (PortServeurCptFourni) serveurComposant.getInterfaceElement("PortServeurCptFourni"));
        BindingLinkRequis bindingLinkRequis = new BindingLinkRequis((PortServeurCptRequis) serveurComposant.getInterfaceElement("PortServeurCptRequis"), (PortServeurConfigRequis)this.getInterface("PortServeurConfigRequis"));
    }

    @Override
    public void update(Observable o, Object arg) {

            if(o instanceof PortServeurFourni ) {

                ((PortServeurConfigFourni) getInterface("portServeurConfigFourni")).sendResponse(arg);

            }else if(o instanceof PortServeurConfigRequis) {

                ((PortServeurRequis) getInterface("PortServeurRequis")).sendToConnexionManager(arg);
            }
    }

}
