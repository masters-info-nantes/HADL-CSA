package hadl.m1.attachments;

import hadl.m1.client.PortReceptionReponse;
import hadl.m1.connecteur.RoleClientRpcCalled;
import hadl.m2.liens.attachment.AttachmentToPort;

import java.util.Observable;

public class AttachmentReceptionReponse extends AttachmentToPort {

	public AttachmentReceptionReponse(RoleClientRpcCalled rf,
			PortReceptionReponse pfr) {
		super(rf, pfr);
		this.role.addObserver(this);

	}

	public void update(Observable o, Object arg) {

		if (o instanceof RoleClientRpcCalled) {
			System.out.print(this.getClass().getSimpleName()+" -> ");
			((PortReceptionReponse) this.port).getResponse(arg);
		}
	}
}
