package hadl.m2.composant;

import java.util.ArrayList;

import hadl.m2.composant.proprietes.ContraintesTechniques;
import hadl.m2.composant.proprietes.Proprietes;
import hadl.m2.element.Element;

public abstract class Composant extends Element {
	ArrayList<Proprietes> propertiesList = new ArrayList<>();
	ContraintesTechniques ct = new ContraintesTechniques();
}
