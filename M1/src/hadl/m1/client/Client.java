package hadl.m1.client;

import hadl.m1.messages.Message;
import hadl.m2.composant.ComposantConfiguration;

import java.util.Observable;
import java.util.Observer;

public class Client extends ComposantConfiguration implements Observer {

	public Client(String name) {
		super(name);

		ServiceReceptionReponse serviceReception = new ServiceReceptionReponse(
				"ServiceReceptionReponse");
		this.addService(serviceReception);
		this.addService(new ServiceEnvoiRequete("ServiceEnvoiRequete"));

		serviceReception.addObserver(this);

	}

	public void sendRequest(Message message) {

		if(message.getHeader().equals(Message.HeaderType.AUTHENTICATION)){
			System.out.println("<- | " + this.getClass().getSimpleName()
					+ "               | Send authentication to the server : " + message.getHeader() +" "+message.getContent());
			ServiceEnvoiRequete service = (ServiceEnvoiRequete) (this
					.getInterfaceService("ServiceEnvoiRequete"));
			service.sendRequest(message);
		} else if(message.getHeader().equals(Message.HeaderType.BDDREQUEST)){
			String[] stringParts = message.getContent().toLowerCase().split(" ");
			if(stringParts.length >= 3 && stringParts[0].equals("select") && stringParts[2].equals("from")){
				if(stringParts.length >= 5 && !stringParts[4].equals("where")){
					System.out.println("Requête incorrecte : "+ stringParts[4] + " n'est pas reconnu.");
					return;
				}
				System.out.println("<- | " + this.getClass().getSimpleName()
						+ "               | Send request to Serveur : " + message.getHeader() +" "+message.getContent());
				ServiceEnvoiRequete service = (ServiceEnvoiRequete) (this
						.getInterfaceService("ServiceEnvoiRequete"));
				service.sendRequest(message);
			}else{
				System.out.println("Requête incorrecte.");
				return;
			}
		}else{
			System.out.println("Type de message inconnu.");
			return;
		}
	}

	public void update(Observable o, Object arg) {
		if (o instanceof ServiceReceptionReponse) {
			System.out.println("-> | " + this.getClass().getSimpleName()
					+ "    | Receive a message from the server : " + ((Message)arg).getContent()+"\n\n-------------------------------------\n");
		}
	}

}
