package hadl.m2.interfaces;

public abstract class Interface {

	enum Mode {
		SYNCHRONE, ASYNCHRONE, CONTINUE;
	}

	protected Mode mode;

}
