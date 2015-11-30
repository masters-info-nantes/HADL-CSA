package hadl.m1.serveur.serveurComposant;

import hadl.m2.composant.ComposantConfiguration;

import java.util.Observable;
import java.util.Observer;

public class ServeurComposant extends ComposantConfiguration implements
		Observer {

	public ServeurComposant(String name) {
		super(name);
		ServiceEnvoiReponse serviceEnvoiReponse = new ServiceEnvoiReponse(
				"serviceEnvoiReponse");
		ServiceReceptionRequete serviceReceptionRequete = new ServiceReceptionRequete(
				"serviceReceptionRequete");
		ServiceConnectionFrom serviceConnectionFrom = new ServiceConnectionFrom(
				"serviceConnectionFrom");
		ServiceConnectionTo serviceConnectionTo = new ServiceConnectionTo(
				"serviceConnectionTo");

		this.addService(serviceReceptionRequete);
		this.addService(serviceEnvoiReponse);
		this.addService(serviceConnectionTo);
		this.addService(serviceConnectionFrom);

		serviceReceptionRequete.addObserver(this);
		serviceConnectionFrom.addObserver(this);

	}

	public void update(Observable o, Object arg) {
		if (o instanceof ServiceReceptionRequete) {
			ServiceEnvoiReponse serviceEnvoiReponse = (ServiceEnvoiReponse) this
					.getInterfaceElement("ServiceEnvoiReponse");
			serviceEnvoiReponse.post(arg);

		} else if (o instanceof ServiceConnectionFrom) {
			ServiceConnectionTo serviceConnectionTo = (ServiceConnectionTo) this
					.getInterfaceElement("ServiceConnectionTo");
			serviceConnectionTo.post(arg);
		}

	}
}
