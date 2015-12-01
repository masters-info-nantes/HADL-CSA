package hadl.m1.messages;

public abstract class Message {



    public enum HeaderType {
       AUTHENTIFICATION,
       BDDREQUEST
    }

    protected String content;
    protected HeaderType header;

	public String getContent(){
		return content;
	}

    public HeaderType getHeader() {
        return header;
    }
}
