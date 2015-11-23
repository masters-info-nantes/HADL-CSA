package hadl.m1.serveur.attachments;

import hadl.m2.interfaces.ports.PortCptConfigFourni;
import hadl.m2.interfaces.roles.RoleRequis;
import hadl.m2.liens.attachment.AttachmentToRole;

import java.util.Observable;

public class AttachmentSecurityAuthorizationTo extends AttachmentToRole {

	public AttachmentSecurityAuthorizationTo(PortCptConfigFourni pcf,
			RoleRequis rr) {
		super(pcf, rr);
		// TODO Auto-generated constructor stub
	}

	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}

}
