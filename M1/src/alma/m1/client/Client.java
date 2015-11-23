package alma.m1.client;

import hadl.m2.composant.ComposantConfiguration;

import java.util.Observable;
import java.util.Observer;

public class Client extends ComposantConfiguration implements Observer {

	public Client(String name) {
		super(name);

		ServiceReceptionReponse serviceReception = new ServiceReceptionReponse(
				"ServiceReceptionReponse");
		this.addInterface(serviceReception);
		this.addInterface(new ServiceEnvoiRequete("ServiceEnvoiRequete"));

		serviceReception.addObserver(this);

	}

	public void send(Object message) {

		System.out.println("<- | " + this.getClass().getSimpleName()
				+ "               | Send to Serveur : " + message);
		ServiceEnvoiRequete service = (ServiceEnvoiRequete) (this
				.getInterfaceElement("ServiceEnvoiRequete"));
		service.sendMessage(message);
	}

	public void update(Observable o, Object arg) {
		if (o instanceof ServiceReceptionReponse) {
			System.out.println("-> | " + this.getClass().getSimpleName()
					+ "    | Reception of a message from Serveur : " + arg);
		}
	}

}
