package hadl.m1.serveur.attachments;

import java.util.Observable;

import hadl.m1.serveur.composants.database.PortSecurityManagementFrom;
import hadl.m1.serveur.connecteurs.securityQuery.RoleDbSqCalled;
import hadl.m2.interfaces.ports.PortCptConfigRequis;
import hadl.m2.interfaces.roles.RoleFourni;
import hadl.m2.liens.attachment.AttachmentToPort;

public class AttachmentSecurityManagementFrom extends AttachmentToPort {

	public AttachmentSecurityManagementFrom(RoleFourni rf, PortCptConfigRequis pfr) {
		super(rf, pfr);

		rf.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {

		if (o instanceof RoleDbSqCalled) {
			((PortSecurityManagementFrom) port).receiveFromSecurityQuery(arg);
		}
	}

}
