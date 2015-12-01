package hadl.m1.serveur.attachments;

import java.util.Observable;

import hadl.m1.serveur.composants.database.PortQueryDatabaseTo;
import hadl.m1.serveur.connecteurs.sqlQuery.RoleDbSQLqCaller;
import hadl.m2.interfaces.ports.PortCptConfigFourni;
import hadl.m2.interfaces.roles.RoleRequis;
import hadl.m2.liens.attachment.AttachmentToRole;

public class AttachmentQueryDatabaseTo extends AttachmentToRole {

	public AttachmentQueryDatabaseTo(PortCptConfigFourni pcf, RoleRequis rr) {
		super(pcf, rr);

		pcf.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {

		if (o instanceof PortQueryDatabaseTo) {
			((RoleDbSQLqCaller) role).receiveFromDatabase(arg);
		}
	}

}
