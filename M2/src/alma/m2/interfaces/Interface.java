package alma.m2.interfaces;

import java.util.Observable;

public abstract class Interface extends Observable {

	enum Mode {
		SYNCHRONE, ASYNCHRONE, CONTINUE;
	}

	protected Mode mode;

}
