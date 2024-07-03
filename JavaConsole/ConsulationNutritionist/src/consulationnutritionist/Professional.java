package conusltapi;

public class Professional {
    private String usernameProfessional;
    private String specialty;

    public Professional() {
    }

    public Professional(String nameProfessional, String specialty) {
        this.usernameProfessional = nameProfessional;
        this.specialty = specialty;
    }
    
    // Visualização de profissionais do sistema 
    public void showProfessional(){
        System.out.println("Nome: " + this.usernameProfessional + "\nEspecialidade: " + this.specialty); 
    }
    
    // Visualizar o nome do profissional escolhido para determinada consulta
    public String showNameProfessional(){
        return usernameProfessional;
    }

    public String getUserameProfessional() {
        return usernameProfessional;
    }

    public String getSpecialty() {
        return specialty;
    }
}
