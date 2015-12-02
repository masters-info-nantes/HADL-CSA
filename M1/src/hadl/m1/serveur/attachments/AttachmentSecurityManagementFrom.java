package hadl.m1.serveur.attachments;

import hadl.m1.serveur.composants.database.PortSecurityManagementFrom;
import hadl.m1.serveur.connecteurs.securityQuery.RoleDbSqCalled;
import hadl.m2.interfaces.ports.PortCptConfigRequis;
import hadl.m2.interfaces.roles.RoleFourni;
import hadl.m2.liens.attachment.AttachmentToPort;

import java.util.Observable;

public class AttachmentSecurityManagementFrom extends AttachmentToPort {

	public AttachmentSecurityManagementFrom(RoleFourni rf, PortCptConfigRequis pfr) {
		super(rf, pfr);

		rf.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {

        if (o instanceof RoleDbSqCalled) {
        	System.out.print(this.getClass().getSimpleName()+" -> ");
			((PortSecurityManagementFrom) port).receiveFromSecurityQuery(arg);
		}
	}

}
