package hadl.m2.composant;

import hadl.m2.composant.proprietes.ContraintesTechniques;
import hadl.m2.composant.proprietes.Proprietes;
import hadl.m2.element.Element;

import java.util.ArrayList;


public abstract class Composant extends Element {
	ArrayList<Proprietes> propertiesList = new ArrayList<>();
	ContraintesTechniques ct = new ContraintesTechniques();
}
