package hadl.m2.liens.attachment;

import hadl.m2.interfaces.ports.PortCptConfigFourni;
import hadl.m2.interfaces.roles.RoleRequis;

import java.util.Observer;

public abstract class AttachmentToRole implements Attachment, Observer {

	protected PortCptConfigFourni port;
	protected RoleRequis role;

	public AttachmentToRole(PortCptConfigFourni pcf, RoleRequis rr) {
		port = pcf;
		role = rr;

		System.out.println("Attachement link created : " + port.getName()
				+ " --> " + role.getName());
	}
}