package alma.m2.composant;

import java.util.ArrayList;

import alma.m2.composant.proprietes.ContraintesTechniques;
import alma.m2.composant.proprietes.Proprietes;
import alma.m2.element.Element;

public abstract class Composant extends Element {
	ArrayList<Proprietes> propertiesList = new ArrayList<>();
	ContraintesTechniques ct = new ContraintesTechniques();
}
