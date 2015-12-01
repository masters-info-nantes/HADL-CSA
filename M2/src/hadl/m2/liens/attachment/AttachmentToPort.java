package hadl.m2.liens.attachment;

import hadl.m2.interfaces.ports.PortCptConfigRequis;
import hadl.m2.interfaces.roles.RoleFourni;

import java.util.Observer;

public abstract class AttachmentToPort implements Attachment, Observer {
	protected RoleFourni role;
	protected PortCptConfigRequis port;

	public AttachmentToPort(RoleFourni rf, PortCptConfigRequis pfr) {
		role = rf;
		port = pfr;
        System.out.println("Attachement link created :" + role.getName()
				+ "-->" + port.getName());
	}

}
