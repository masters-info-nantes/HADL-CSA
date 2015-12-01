package hadl.m1.messages;

public class Query extends Message {
    private HeaderType header;

	public Query(HeaderType header , String contenu){
		this.content = contenu;
		this.header = header;
	}

	public HeaderType getHeader(){
		return header;
	}
}
