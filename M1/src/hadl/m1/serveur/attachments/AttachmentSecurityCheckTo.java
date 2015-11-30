package hadl.m1.serveur.attachments;

import hadl.m1.serveur.composants.connectionManager.PortSecurityCheckTo;
import hadl.m1.serveur.connecteurs.clearanceRequest.RoleCmCrCaller;
import hadl.m2.liens.attachment.AttachmentToRole;

import java.util.Observable;

public class AttachmentSecurityCheckTo extends AttachmentToRole {

	public AttachmentSecurityCheckTo(PortSecurityCheckTo pcf, RoleCmCrCaller rr) {
		super(pcf, rr);
        pcf.addObserver(this);
	}

	public void update(Observable o, Object arg) {
		if(o instanceof PortSecurityCheckTo) {
            ((RoleCmCrCaller)this.role).sendRequest(arg);
        }

	}

}
