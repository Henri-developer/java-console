package conusltapi;

public class Query {
    private String date;
    private String hours;
    private String professionalID;
    private InterfaceClient client;
    

    public Query() {
    }

    public Query(String date, String hours, String professionalID,  InterfaceClient client) {
        this.date = date;
        this.hours = hours;
        this.professionalID = professionalID;
        this.client = client;
    }
    
    // Visualização da consulta  
    public void showQuery(){ 
        System.out.println("|- Data: " + this.date + " -| " + "|- Horário: " + this.hours + " -| "
                + "|- Profissional: " + this.professionalID);   
        client.showNameClient();
    }   

    public String getDate() {
        return date;
    }

    public String getHours() {
        return hours;
    }

    public InterfaceClient getClient() {
        return client;
    }
}
