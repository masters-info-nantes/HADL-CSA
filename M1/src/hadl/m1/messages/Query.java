package hadl.m1.messages;

public class Query extends Message {
	String header;
	
	public Query(String entete, String contenu){
		this.content = contenu;
		this.header = entete;
	}
	
	public String getHeader(){
		return header;
	}
}
