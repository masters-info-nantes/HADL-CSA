package hadl.m1.serveur.attachments;

import java.util.Observable;

import hadl.m1.serveur.composants.database.PortQueryDatabaseFrom;
import hadl.m1.serveur.connecteurs.sqlQuery.RoleDbSQLqCalled;
import hadl.m2.interfaces.ports.PortCptConfigRequis;
import hadl.m2.interfaces.roles.RoleFourni;
import hadl.m2.liens.attachment.AttachmentToPort;

public class AttachmentQueryDatabaseFrom extends AttachmentToPort {

	public AttachmentQueryDatabaseFrom(RoleFourni rf, PortCptConfigRequis pfr) {
		super(rf, pfr);

		rf.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {

		if (o instanceof RoleDbSQLqCalled) {
			((PortQueryDatabaseFrom) port).receiveFromSqlQuery(arg);
		}
	}

}
