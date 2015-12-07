package hadl.m1.serveur.composants.database;

import hadl.m1.messages.Query;
import hadl.m1.messages.Response;
import hadl.m2.composant.ComposantConfiguration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

public class Database extends ComposantConfiguration implements Observer {
    private ArrayList<String> users;
    private HashMap<String,String> data;

    public Database(String name) {
        super(name);

        users= new ArrayList<>();

        users.add("TOTO");
        users.add("TATA");
        users.add("TITI");

        data = new HashMap<>();

        data.put("france","Paris");
        data.put("canada","Montréal");
        data.put("espagne","Madrid");
        data.put("allemagne","Berlin");



        ServiceQueryDatabaseFrom serviceQueryDatabaseFrom = new ServiceQueryDatabaseFrom("serviceQueryDatabaseFrom");
        ServiceQueryDatabaseTo serviceQueryDatabaseTo = new ServiceQueryDatabaseTo("serviceQueryDatabaseTo");

        serviceQueryDatabaseFrom.addObserver(this);

        ServiceSecurityManagementFrom serviceSecurityManagementFrom = new ServiceSecurityManagementFrom("serviceSecurityManagementFrom");
        ServiceSecurityManagementTo serviceSecurityManagementTo = new ServiceSecurityManagementTo("serviceSecurityManagementTo");

        serviceSecurityManagementFrom.addObserver(this);

        addService(serviceQueryDatabaseTo);
        addService(serviceQueryDatabaseFrom);
        addService(serviceSecurityManagementFrom);
        addService(serviceSecurityManagementTo);

        serviceSecurityManagementFrom.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {

        if(o instanceof ServiceSecurityManagementFrom){
        	System.out.println("\n   "+this.getClass().getSimpleName()+"  : Receive from SecurityManager");
            if(arg instanceof Query) {
                if(exist(((Query)arg).getContent())){

                    Response reponse = new Response("user does exist", true);
                    ((ServiceSecurityManagementTo)getInterfaceService("ServiceSecurityManagementTo")).sendToSecurityQuery(reponse);
                }else{

                    Response reponse = new Response("user does not exist",false);
                    ((ServiceSecurityManagementTo)getInterfaceService("ServiceSecurityManagementTo")).sendToSecurityQuery(reponse);
                }
            }


        } else if(o instanceof ServiceQueryDatabaseFrom) {
        	System.out.println("\n   "+this.getClass().getSimpleName()+"  : Receive from ConnectionManager");
            if(arg instanceof Query) {
                String[] req= ((Query) arg).getContent().toLowerCase().split(" ");
                
                if(req[1].equals("*")){

                    // i.e Select * from data (4) avec ";" (5)
                    if((req.length==3 || req.length==4) && req[0].equals("select") && req[2].equals("from")){
                    	if(req[3].equals("data")){
							String requestResult= "";
							for(String key : data.keySet()) {
							    requestResult +="\n"+key+" : "+data.get(key);
							}
							
							Response reponse = new Response(requestResult,true);
							((ServiceQueryDatabaseTo)getInterfaceService("ServiceQueryDatabaseTo")).sendToSqlQuery(reponse);
                    	}else{
                    		Response reponse = new Response(req[3]+" is not a table",false);
                    		((ServiceQueryDatabaseTo)getInterfaceService("ServiceQueryDatabaseTo")).sendToSqlQuery(reponse);
                    	}
                    }else{
                        Response reponse = new Response("MalFormed sql query",false);
                        ((ServiceQueryDatabaseTo)getInterfaceService("ServiceQueryDatabaseTo")).sendToSqlQuery(reponse);
                    }


                }else if(req[1].toLowerCase().equals("capitale")) {
                    //i.e select capitale from data where pays = "France" (8) avec ; (9)
                    if(((req.length == 8) || (req.length == 9)) && req[0].equals("select") && req[2].equals("from") && req[4].equals("where")) {
                    	if(req[3].equals("data")){
	                        // on retire les '' et/ou ""
	                        String param = req[7].replace("\'","");
	                        param = param.replace("\"","");
	                        if(data.containsKey(param)){
		                        String res = data.get(param.toLowerCase());
		
		                        Response reponse = new Response(res,true);
		                        ((ServiceQueryDatabaseTo)getInterfaceService("ServiceQueryDatabaseTo")).sendToSqlQuery(reponse);
	                        }else{
	                        	Response reponse = new Response("Unknown key",false);
	                            ((ServiceQueryDatabaseTo)getInterfaceService("ServiceQueryDatabaseTo")).sendToSqlQuery(reponse);
	                        }
	                    }else{
	                		Response reponse = new Response(req[3]+" is not a table",false);
	                		((ServiceQueryDatabaseTo)getInterfaceService("ServiceQueryDatabaseTo")).sendToSqlQuery(reponse);
	                	}
                    }else{
                        Response reponse = new Response("MalFormed sql query",false);
                        ((ServiceQueryDatabaseTo)getInterfaceService("ServiceQueryDatabaseTo")).sendToSqlQuery(reponse);
                    }

                }else {
                    Response reponse = new Response(req[1]+" is not a key",false);
                    ((ServiceQueryDatabaseTo)getInterfaceService("ServiceQueryDatabaseTo")).sendToSqlQuery(reponse);
                }
            }
        }
    }



    public boolean exist(String username){
        return users.contains(username);
    }
}
