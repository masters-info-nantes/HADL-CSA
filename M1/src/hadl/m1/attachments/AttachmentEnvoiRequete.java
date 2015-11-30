package hadl.m1.attachments;

import hadl.m1.client.PortEnvoiRequete;
import hadl.m1.connecteur.RoleClientRpcCaller;
import hadl.m1.messages.Query;
import hadl.m2.liens.attachment.AttachmentToRole;

import java.util.Observable;

public class AttachmentEnvoiRequete extends AttachmentToRole {

	public AttachmentEnvoiRequete(RoleClientRpcCaller rcrc, PortEnvoiRequete per) {
		super(per, rcrc);
		this.port.addObserver(this);
	}

	public void update(Observable o, Object arg) {
		if (o instanceof PortEnvoiRequete) {
			if (arg instanceof Query) {
				((RoleClientRpcCaller) this.role).getRequete(arg);
			}
		}

	}

}
