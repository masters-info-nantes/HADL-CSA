package hadl.m1.serveur.attachments;

import hadl.m1.serveur.composants.securityManager.PortChQueryTo;
import hadl.m1.serveur.connecteurs.securityQuery.RoleSmSqCaller;
import hadl.m2.interfaces.ports.PortCptConfigFourni;
import hadl.m2.interfaces.roles.RoleRequis;
import hadl.m2.liens.attachment.AttachmentToRole;

import java.util.Observable;

public class AttachmentChQueryTo extends AttachmentToRole {

	public AttachmentChQueryTo(PortCptConfigFourni pcf, RoleRequis rr) {
		super(pcf, rr);

		pcf.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {

		if (o instanceof PortChQueryTo) {
			((RoleSmSqCaller) role).receiveFromSecurityManager(arg);
		}
	}

}
