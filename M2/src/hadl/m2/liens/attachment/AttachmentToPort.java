package hadl.m2.liens.attachment;

import java.util.Observable;
import java.util.Observer;

import hadl.m2.interfaces.ports.PortCptConfigFourni;
import hadl.m2.interfaces.roles.RoleRequis;

public class AttachmentToPort implements Attachment, Observer {

	private PortCptConfigFourni port;
	private RoleRequis role;

	public AttachmentToPort(PortCptConfigFourni pcf, RoleRequis rr) {
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
