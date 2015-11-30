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
import hadl.m1.serveur.serveurComposant.ServeurComposant;
import hadl.m2.configuration.Configuration;
import hadl.m2.interfaces.ports.PortConfigFourni;
import hadl.m2.interfaces.ports.PortCptConfigFourni;
import hadl.m2.interfaces.ports.PortCptConfigRequis;
import hadl.m2.interfaces.roles.RoleFourni;
import hadl.m2.interfaces.roles.RoleRequis;

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
        ConnectionManager connexionManager = new ConnectionManager("connexionManager");
        SecurityManager securityManager = new SecurityManager("securityManager");

        //composition avec les connecteurs
        ClearanceRequest clearanceRequest = new ClearanceRequest("clearanceRequest");
        SQLQuery sqlQuery = new SQLQuery("sqlQuery");
        SecurityQuery securityQuery = new SecurityQuery("securityQuery");

        addElement(serveurComposant);
        addElement(database);
        addElement(connexionManager);
        addElement(securityManager);

        addElement(clearanceRequest);
        addElement(sqlQuery);
        addElement(securityQuery);

        AttachmentSecurityCheckFrom attachmentSecurityCheckFrom  = new AttachmentSecurityCheckFrom((RoleFourni)clearanceRequest.getRole("rolecmcrcalled"), (PortCptConfigRequis)connexionManager.getInterfaceElement("portsecuritycheckfrom"));
        AttachmentSecurityCheckTo attachmentSecurityCheckTo = new AttachmentSecurityCheckTo((PortCptConfigFourni)connexionManager.getInterfaceElement("portsecuritycheckto"), (RoleRequis)clearanceRequest.getRole("cmcrcaller"));

        AttachmentChQueryFrom attachmentChQueryFrom = new AttachmentChQueryFrom((RoleFourni) securityQuery.getRole("RoleSmSqCalled"), (PortCptConfigRequis) securityManager.getInterfaceElement("PortChQueryFrom"));
        AttachmentChQueryTo attachmentChQueryTo = new AttachmentChQueryTo((PortCptConfigFourni) securityManager.getInterfaceElement("PortChQueryTo"), (RoleRequis) securityQuery.getRole("RoleSmSqCalled"));

        AttachmentDatabaseQueryFrom attachmentDatabaseQueryFrom = new AttachmentDatabaseQueryFrom((RoleFourni) sqlQuery.getRole("rolecmsqlqcalled") ,(PortCptConfigRequis)connexionManager.getInterfaceElement("portDataBasequeryFrom") );
        AttachmentDatabaseQueryTo attachmentDatabaseQueryTo = new AttachmentDatabaseQueryTo((PortCptConfigFourni)connexionManager.getInterfaceElement("portdatabasequeryto"), (RoleRequis)sqlQuery.getRole("rolecmsqlqcaller"));

        AttachmentQueryDatabaseFrom attachmentQueryDatabaseFrom = new AttachmentQueryDatabaseFrom((RoleFourni)sqlQuery.getRole("roledbsqlqcalled"), (PortCptConfigRequis)database.getInterfaceElement("portqueryDatabasefrom"));
        AttachmentQueryDatabaseTo attachmentQueryDatabaseTo = new AttachmentQueryDatabaseTo((PortCptConfigFourni)database.getInterfaceElement("portqueryDatabaseto"), (RoleRequis)sqlQuery.getRole("roledbsqlqcaller"));

        AttachmentSecurityAuthorizationFrom  attachmentSecurityAuthorizationFrom = new AttachmentSecurityAuthorizationFrom((RoleFourni)clearanceRequest.getRole("rolesmcrcaller"), (PortCptConfigRequis)securityManager.getInterfaceElement("portsecurityauthorizationto"));
        AttachmentSecurityAuthorizationTo attachmentSecurityAuthorizationTo = new AttachmentSecurityAuthorizationTo((PortCptConfigFourni)securityManager.getInterfaceElement("portsecurityauthorizationto"), (RoleRequis)clearanceRequest.getRole("rolesmcrcaller"));

        AttachmentSecurityManagementFrom attachmentSecurityManagementFrom = new AttachmentSecurityManagementFrom((RoleFourni)securityQuery.getRole("roledbsqlcalled"), (PortCptConfigRequis)database.getInterfaceElement("portsecuritymanagementfrom"));
        AttachmentSecurityManagementTo attachmentSecurityManagementTo = new AttachmentSecurityManagementTo((PortCptConfigFourni)database.getInterfaceElement("portsecuritymanagementfrom"), (RoleRequis)securityQuery.getRole("roledbsqlcalled"));

        BindToConnectionManager bindToConnectionManager = new BindToConnectionManager((PortServeurRequis) this.getInterface("Portserveurrequis") , (PortExternalSocketFrom) connexionManager.getInterfaceElement("portexternalsocketfrom"));
        BindToServeur bindToServeur = new BindToServeur((PortConfigFourni) this.getInterface("portserveurrequis"), (PortExternalSocketTo)connexionManager.getInterfaceElement(""));

	}

    @Override
    public void update(Observable o, Object arg) {
            //attention la requete du client passe par le port fourni a cause du fournie-fournie de binding
            if(o instanceof PortServeurConfigFourni ) {
                ((PortServeurRequis)getInterface("PortServeurRequis")).sendRequest(arg);
            }else if(o instanceof PortServeurRequis) { // on reçois une réponse des composants serveur
                // on utilise l'autre lien requis-requis (meme si ça va a l'encontre du port)
                ((PortServeurConfigRequis) getInterface("portServeurConfigRequis")).sendResponse(arg);

            }
    }

}
