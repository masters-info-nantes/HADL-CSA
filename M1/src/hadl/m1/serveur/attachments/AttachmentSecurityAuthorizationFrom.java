package hadl.m1.serveur.attachments;

import java.util.Observable;

import hadl.m1.serveur.composants.securityManager.PortSecurityAuthorizationFrom;
import hadl.m1.serveur.connecteurs.clearanceRequest.RoleSmCrCalled;
import hadl.m2.interfaces.ports.PortCptConfigRequis;
import hadl.m2.interfaces.roles.RoleFourni;
import hadl.m2.liens.attachment.AttachmentToPort;

public class AttachmentSecurityAuthorizationFrom extends AttachmentToPort {

	public AttachmentSecurityAuthorizationFrom(RoleFourni rf, PortCptConfigRequis pfr) {
		super(rf, pfr);

		rf.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {

		if (o instanceof RoleSmCrCalled) {
			((PortSecurityAuthorizationFrom) port).receiveFromClearanceRequest(arg);
		}
	}

}
