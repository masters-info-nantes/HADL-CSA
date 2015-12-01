package hadl.m1.serveur.attachments;

import java.util.Observable;

import hadl.m1.serveur.composants.connectionManager.PortSecurityCheckTo;
import hadl.m1.serveur.connecteurs.clearanceRequest.RoleCmCrCaller;
import hadl.m2.interfaces.ports.PortCptConfigFourni;
import hadl.m2.interfaces.roles.RoleRequis;
import hadl.m2.liens.attachment.AttachmentToRole;

public class AttachmentSecurityCheckTo extends AttachmentToRole {

	public AttachmentSecurityCheckTo(PortCptConfigFourni pcf, RoleRequis rr) {
		super(pcf, rr);

		pcf.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {

		if (o instanceof PortSecurityCheckTo) {
			((RoleCmCrCaller) role).receiveFromConnectionManager(arg);
		}
	}

}
