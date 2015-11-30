package hadl.m1.serveur.attachments;

import hadl.m2.interfaces.ports.PortCptConfigRequis;
import hadl.m2.interfaces.roles.RoleFourni;
import hadl.m2.liens.attachment.AttachmentToPort;

import java.util.Observable;

public class AttachmentChQueryFrom extends AttachmentToPort {

	public AttachmentChQueryFrom(RoleFourni rf, PortCptConfigRequis pfr) {
		super(rf, pfr);
		rf.addObserver(this);
	}

	public void update(Observable o, Object arg) {

	}

}
