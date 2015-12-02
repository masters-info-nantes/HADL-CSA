package hadl.m1.messages;

public abstract class Message {



    public enum HeaderType {
       AUTHENTICATION,
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
