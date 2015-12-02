package hadl.m1.serveur.attachments;

import java.util.Observable;

import hadl.m1.serveur.composants.securityManager.PortChQueryFrom;
import hadl.m1.serveur.connecteurs.securityQuery.RoleSmSqCalled;
import hadl.m2.interfaces.ports.PortCptConfigRequis;
import hadl.m2.interfaces.roles.RoleFourni;
import hadl.m2.liens.attachment.AttachmentToPort;

public class AttachmentChQueryFrom extends AttachmentToPort {

	public AttachmentChQueryFrom(RoleFourni rf, PortCptConfigRequis pfr) {
		super(rf, pfr);

		rf.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {

		if (o instanceof RoleSmSqCalled) {
			System.out.print(this.getClass().getSimpleName()+" -> ");
			((PortChQueryFrom) port).receiveFromSecurityQuery(arg);
		}
	}

}
