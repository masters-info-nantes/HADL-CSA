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
        data.put("espagne","Barcelone");



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
            if(arg instanceof Query) {
                if(exist(((Query)arg).getContent())){

                    Response reponse = new Response("user exist", true);
                    ((ServiceSecurityManagementTo)getInterfaceService("ServiceSecurityManagementTo")).sendToSecurityQuery(reponse);
                }else{

                    Response reponse = new Response("user non exist",false);
                    ((ServiceSecurityManagementTo)getInterfaceService("ServiceSecurityManagementTo")).sendToSecurityQuery(reponse);
                }
            }


        } else if(o instanceof ServiceQueryDatabaseFrom) {
            if(arg instanceof Query) {
                String[] req= ((Query) arg).getContent().toLowerCase().split(" ");
                if(req[1].equals("*")){

                    // i.e Select * from Capital (4) avec ";" (5)
                    if(req.length==3 || req.length==4){

                        String requestResult= "";
                        for(String key : data.keySet()) {
                            requestResult +=key+" "+data.get(key)+"\n";
                        }

                        Response reponse = new Response(requestResult,true);
                        ((ServiceQueryDatabaseTo)getInterfaceService("ServiceSecurityManagementTo")).sendToSqlQuery(reponse);

                    }else{
                        Response reponse = new Response("MalFormed sql query",false);
                        ((ServiceQueryDatabaseTo)getInterfaceService("ServiceSecurityManagementTo")).sendToSqlQuery(reponse);
                    }


                }else if(req[1].toLowerCase().equals("capital")) {
                    //i.e select capital from capitale where pays = "France" (8) avec ; (9)
                    if((req.length == 8) || (req.length == 9)) {

                        String res = req[7]+" "+data.get(req[7].toLowerCase());

                        Response reponse = new Response(res,true);
                        ((ServiceQueryDatabaseTo)getInterfaceService("ServiceSecurityManagementTo")).sendToSqlQuery(reponse);

                    }else{
                        Response reponse = new Response("MalFormed sql query",false);
                        ((ServiceQueryDatabaseTo)getInterfaceService("ServiceSecurityManagementTo")).sendToSqlQuery(reponse);
                    }

                }else {
                    Response reponse = new Response(req[2]+" :is not in the table",false);
                    ((ServiceQueryDatabaseTo)getInterfaceService("ServiceSecurityManagementTo")).sendToSqlQuery(reponse);
                }
            }
        }
    }



    public boolean exist(String username){
        return users.contains(username);
    }
}
