package conusltapi;

import java.util.ArrayList;
import java.util.List;

public class ListRegister {
    private List<Register> registers; 

    public ListRegister() {
        this.registers = new ArrayList<Register>();
    }
    
    // Adicionar Usuário
    public void addRegister(String username, String password, String email, String cpf, int age){
        this.registers.add(new Register(username, password, email, cpf, age));
    }
    
    // Remover Usuário 
    public void deleteRegister(int id){
        if(id > 0 && id < registers.size() ){
            this.registers.remove(id);
            System.out.println("Registro de ID " + (1 + id) + " removido com sucesso!");
        } else{
            System.out.println("Registro não existente!");
        }
    }
    
    // Visualizar Usuários cadastrados 
    public void viewRegister(){
        if(registers.isEmpty()){
            System.out.println("Não á cadastros no sistema!");
        } else{
            for (int i = 0; i < registers.size(); i++){
                System.out.println("Usuário " + (i + 1) + ":");
                registers.get(i).showRegister(); 
                System.out.println("");
            }
        }
    }
}
