package hadl.m1.serveur.attachments;

import hadl.m1.serveur.composants.database.PortSecurityManagementTo;
import hadl.m1.serveur.connecteurs.securityQuery.RoleDbSqCaller;
import hadl.m2.interfaces.ports.PortCptConfigFourni;
import hadl.m2.interfaces.roles.RoleRequis;
import hadl.m2.liens.attachment.AttachmentToRole;

import java.util.Observable;

public class AttachmentSecurityManagementTo extends AttachmentToRole {

	public AttachmentSecurityManagementTo(PortCptConfigFourni pcf, RoleRequis rr) {
		super(pcf, rr);

		pcf.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {

		if (o instanceof PortSecurityManagementTo) {
			System.out.print(this.getClass().getSimpleName()+" -> ");
			((RoleDbSqCaller) role).receiveFromDatabase(arg);
		}
	}

}
