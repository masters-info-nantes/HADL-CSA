package hadl.m1.serveurComposant.attachments;

import hadl.m1.connecteur.RoleServerRpcCaller;
import hadl.m1.messages.Response;
import hadl.m1.serveur.serveurComposant.PortEnvoiReponse;
import hadl.m2.liens.attachment.AttachmentToRole;

import java.util.Observable;

public class AttachmentEnvoiReponse extends AttachmentToRole {

	public AttachmentEnvoiReponse(PortEnvoiReponse pcf, RoleServerRpcCaller rr) {
		super(pcf, rr);
		this.port.addObserver(this);
	}

	public void update(Observable o, Object arg) {
		if (o instanceof PortEnvoiReponse) {
			if (arg instanceof Response) {
				((RoleServerRpcCaller) this.role).getResponse(arg);
			}
		}
	}

}
