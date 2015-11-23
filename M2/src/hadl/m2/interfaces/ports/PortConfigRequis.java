package hadl.m2.interfaces.ports;

public class PortConfigRequis extends PortConfiguration {

	public PortConfigRequis(String name) {
		this.name = name;
	}

	public void post(Object arg) {
		this.setChanged();
		this.notifyObservers(arg);

	}
}
