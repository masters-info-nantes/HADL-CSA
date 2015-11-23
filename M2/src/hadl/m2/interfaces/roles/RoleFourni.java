package hadl.m2.interfaces.roles;

import java.util.Observer;

public abstract class RoleFourni extends Role implements Observer {

	public RoleFourni(String name) {
		this.name = name;
	}

}
