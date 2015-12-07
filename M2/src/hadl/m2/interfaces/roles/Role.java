package hadl.m2.interfaces.roles;

import java.util.Observable;

public abstract class Role extends Observable {
	protected String name;

	public String getName() {
		return name;
	}
}
