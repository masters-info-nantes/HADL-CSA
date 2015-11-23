package hadl.m2.liens.attachment;

import hadl.m2.interfaces.ports.PortCptConfigFourni;
import hadl.m2.interfaces.roles.RoleRequis;

import java.util.Observable;
import java.util.Observer;


public class AttachmentToRole implements Attachment, Observer {

	private PortCptConfigFourni port;
	private RoleRequis role;

	public AttachmentToRole(PortCptConfigFourni pcf, RoleRequis rr) {
		port = pcf;
		role = rr;

		System.out.println("Attachement link created :" + port.getName()
				+ "-->" + role.getName());
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}
}