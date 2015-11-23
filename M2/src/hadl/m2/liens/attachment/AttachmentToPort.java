package hadl.m2.liens.attachment;

import hadl.m2.interfaces.ports.PortCptConfigRequis;
import hadl.m2.interfaces.roles.RoleFourni;

import java.util.Observable;
import java.util.Observer;


public class AttachmentToPort implements Attachment, Observer {
	private RoleFourni role;
	private PortCptConfigRequis port;

	public AttachmentToPort(RoleFourni rf, PortCptConfigRequis pfr) {
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
