package conusltapi;

import java.util.LinkedList;
import java.util.Queue;

public class ListQuery {
    private Queue<Query> querys;

    public ListQuery() {
        this.querys = new LinkedList<Query>();
    }
    
    public void addQuery(Query query){
        querys.add(query);
    }
    
    public void removeQuery(int id){
        if(id >= 0 && id < querys.size()){  
            querys.remove(id);
        }
    }
    
    public void viewQuery(){
        if(querys.isEmpty()){
            System.out.println("Não a consultas no momento!");
        } else{
            for(int i = 0; i < querys.size(); i++){
                System.out.println((i + 1) + "° Consulta: ");
                querys.peek().showQuery();   
                System.out.println("");
            }
        }
    }
}
