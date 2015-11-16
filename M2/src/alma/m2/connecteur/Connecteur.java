package alma.m2.connecteur;

import alma.m2.element.Element;

public abstract class Connecteur implements Element {
	enum TypeConnecteur {
		implicite, explicite, enumeree;
	}
}
