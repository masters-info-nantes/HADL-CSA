package hadl.m1.messages;

public abstract class Message {

    public enum HeaderType {
       AUTHENTIFICATION,
       BDDREQUEST
    }

    public String content;


	public String getContent(){
		return content;
	}
}
