package alma.m2.liens.attachment;

import java.util.Observable;
import java.util.Observer;

import alma.m2.interfaces.ports.PortCptConfigRequis;
import alma.m2.interfaces.roles.RoleFourni;

public class AttachmentToRole implements Attachment, Observer {

	private RoleFourni role;
	private PortCptConfigRequis port;

	public AttachmentToRole(RoleFourni rf, PortCptConfigRequis pfr) {
		role = rf;
		port = pfr;

		System.out.println("Attachement link created :" + role.getName()
				+ "-->" + port.getName());
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}
}