package hadl.m1.serveur.attachments;

import hadl.m1.serveur.composants.connectionManager.PortSecurityCheckFrom;
import hadl.m1.serveur.connecteurs.clearanceRequest.RoleCmCrCalled;
import hadl.m2.interfaces.ports.PortCptConfigRequis;
import hadl.m2.interfaces.roles.RoleFourni;
import hadl.m2.liens.attachment.AttachmentToPort;

import java.util.Observable;

public class AttachmentSecurityCheckFrom extends AttachmentToPort {

	public AttachmentSecurityCheckFrom(RoleFourni rf, PortCptConfigRequis pfr) {
		super(rf, pfr);
		
		rf.addObserver(this);
	}

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof RoleCmCrCalled) {
            ((PortSecurityCheckFrom) this.port).sendToConnectionManager(arg);
        }
    }
}
