package hadl.m2.interfaces.ports;

public class PortConfigFourni extends PortConfiguration {

	public PortConfigFourni(String name) {
		this.name = name;
	}

    public void sendRequest(Object arg) {
        setChanged();
        notifyObservers(arg);
    }
}
