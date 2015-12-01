package hadl.m1.messages;

public class Response extends Message {
    private  Boolean success;

	public Response(String contenu,Boolean success){
		this.content = contenu;
        this.success = success;
	}

    public Boolean getSuccess() {
        return success;
    }
}
