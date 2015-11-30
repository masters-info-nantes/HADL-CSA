package hadl.m1.serveurComposant.attachments;

import hadl.m1.connecteur.RoleServerRpcCalled;
import hadl.m1.serveur.serveurComposant.PortReceptionRequete;
import hadl.m2.liens.attachment.AttachmentToPort;

import java.util.Observable;

public class AttachmentReceptionRequete extends AttachmentToPort {

	public AttachmentReceptionRequete(RoleServerRpcCalled rf,
			PortReceptionRequete pfr) {
		super(rf, pfr);
		this.role.addObserver(this);
	}

	public void update(Observable o, Object arg) {
		if (o instanceof RoleServerRpcCalled) {
			if (arg instanceof PortReceptionRequete) {
				((PortReceptionRequete) this.port).getRequete(arg);
			}
		}
	}

}
