package hadl.m1.serveur.attachments;

import java.util.Observable;

import hadl.m1.serveur.composants.connectionManager.PortDatabaseQueryFrom;
import hadl.m1.serveur.connecteurs.sqlQuery.RoleCmSQLqCalled;
import hadl.m2.interfaces.ports.PortCptConfigRequis;
import hadl.m2.interfaces.roles.RoleFourni;
import hadl.m2.liens.attachment.AttachmentToPort;

public class AttachmentDatabaseQueryFrom extends AttachmentToPort {

	public AttachmentDatabaseQueryFrom(RoleFourni rf, PortCptConfigRequis pfr) {
		super(rf, pfr);

		rf.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {

		if (o instanceof RoleCmSQLqCalled) {
			System.out.print(this.getClass().getSimpleName()+" -> ");
			((PortDatabaseQueryFrom) port).receiveFromSqlQuery(arg);
		}
	}

}
