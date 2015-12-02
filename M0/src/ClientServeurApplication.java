import hadl.m1.attachments.AttachmentEnvoiRequete;
import hadl.m1.attachments.AttachmentReceptionReponse;
import hadl.m1.client.*;
import hadl.m1.connecteur.RPC;
import hadl.m1.messages.Message;
import hadl.m1.messages.Query;
import hadl.m1.serveur.serveurComposant.*;
import hadl.m1.serveur.serveurConfiguration.ServeurConfiguration;
import hadl.m1.serveurComposant.attachments.AttachmentEnvoiReponse;
import hadl.m1.serveurComposant.attachments.AttachmentReceptionRequete;

/**
 * Created by david on 01/12/15.
 */
public class ClientServeurApplication {

    public static void main (String [] args) {

        Client client = new Client("client");

        ServiceEnvoiRequete serviceEnvoieRequete = (ServiceEnvoiRequete) client.getInterfaceService("ServiceEnvoiRequete");
        ServiceReceptionReponse serviceReceptionReponse = (ServiceReceptionReponse) client.getInterfaceService("ServiceReceptionReponse");

        RPC rpc = new RPC();

        ServeurConfiguration serveurConfiguration = new ServeurConfiguration("Serveur");

        /**
         * mise en place des liens  attachment entre le clients et le RPC;
         * */
        AttachmentEnvoiRequete attachmentEnvoiRequete = new AttachmentEnvoiRequete(rpc.getRoleClientRpcCaller(), (PortEnvoiRequete) serviceEnvoieRequete.getPort("PortEnvoiRequete"));
        AttachmentReceptionReponse attachmentReceptionReponse = new AttachmentReceptionReponse(rpc.getRoleClientRpcCalled(), (PortReceptionReponse) serviceReceptionReponse.getPort("PortReceptionReponse"));

        /**
         * mise en place des liens attachment entre RPC et serveurComposant;
         */

        // on récupère l'instance du serveurComposant a partir du serveur
        ServeurComposant serveurComposant = (ServeurComposant) serveurConfiguration.getElement("serveurComposant");


        // on récupère les deux instances de ports de serveurComposant;

        ServiceEnvoiReponse serviceEnvoiReponse = (ServiceEnvoiReponse) serveurComposant.getInterfaceService("serviceEnvoiReponse");
        ServiceReceptionRequete serviceReceptionRequete = (ServiceReceptionRequete) serveurComposant.getInterfaceService("ServiceReceptionRequete");

        //on récupère les instances de ports des services de serveurComposant;
        PortEnvoiReponse portEnvoiReponse = (PortEnvoiReponse) serviceEnvoiReponse.getPort("PortEnvoiReponse");
        PortReceptionRequete portReceptionRequete = (PortReceptionRequete) serviceReceptionRequete.getPort("PortReceptionRequete");

        AttachmentEnvoiReponse attachmentEnvoiReponse = new AttachmentEnvoiReponse(portEnvoiReponse, rpc.getRoleServerRpcCaller());
        AttachmentReceptionRequete attachmentReceptionRequete = new AttachmentReceptionRequete(rpc.getRoleServerRpcCalled(),portReceptionRequete);

        Query queryAuthentification = new Query(Message.HeaderType.AUTHENTIFICATION,"TOTa");
        client.sendRequest(queryAuthentification);
        Query querySql = new Query(Message.HeaderType.BDDREQUEST,"Select * from captial ");
        client.sendRequest(querySql);
    }

}
