package conusltapi;

import java.util.ArrayList;
import java.util.List;

public class ListClient {
    private List<Client> clients;

    public ListClient() {
        this.clients = new ArrayList<Client>();
    }
    
    public void addClient(String nameClient, int ageClient, String email, String cpfClient, String number){
        clients.add(new Client(nameClient, ageClient, email, cpfClient, number));
    }
    
    public void removeClient(int id){
        if(id >= 0 && id < clients.size()){
            clients.remove(id);
            System.out.println("Cliente do ID " + (id + 1) + " removido com sucesso!");
        }
    }
    
    public void viewClient(){
        if(clients.isEmpty()){
            System.out.println("Não a clientes cadastrado no sistema!"); 
        } else{
            for(int i = 0; i < clients.size(); i++){
                System.out.println("Cliente " + (i + 1) + ":");
                clients.get(i).showClient();
                System.out.println(""); 
            }
        }
    }
}
