package conusltapi;

import java.util.ArrayList;
import java.util.List;

public class ListProfessional {
    private List<Professional> professionals;

    public ListProfessional() {
        this.professionals = new ArrayList<Professional>();
    }
    
    public void addProfessional(String nameProfessional, String specialty){
        professionals.add(new Professional(nameProfessional, specialty));
    }
    
    public void removeProfessional(int id){ 
        if(id >= 0 && id < professionals.size()){
            professionals.remove(id);
            System.out.println("O Profissional com o ID " + (id + 1) + " removido com sucesso!");
        } else{
            throw new BusineesException("Profissional de ID " + (id + 1) + " não encontrado! Tente mais uma vez...");
        }
    }
    
    
    // Método de escolha de profissional através do ID
    public String chooseID(int id){
        for(int i = 0; i < professionals.size(); i++){
            if(id != i){
                throw new BusineesException("Erro! Tente novamente!"); 
            }
        }
        return professionals.get(id).showNameProfessional(); 
    }
    
    public void viewProfessional(){
        if(professionals.isEmpty()){
            System.out.println("Não a profissionais cadastrados no sistema!");
        } else{
            for(int i = 0; i < professionals.size(); i++){
                System.out.println("Profissional " + (i + 1) + ":"); 
                professionals.get(i).showProfessional();
                System.out.println("");
            }
        }
    }
}
