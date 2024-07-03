package conusltapi;

public class Register {
    private String username;
    private String password;
    private String email;
    private String cpf;
    private int age; 
    private static final int TAMANHO_MIN_SENHA = 7;

    public Register() {
    }

    public Register(String username, String password, String email, String cpf, int age) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.cpf = cpf;
        this.age = age;
    }
    
    // Verificando tamanho da senha
    public void checkPasswordLength(String password){
        if(password.length() < TAMANHO_MIN_SENHA){
            throw new BusineesException("Tente novamente! Tamanho mínimo da senha é de: 7 caracteres"); 
        }
    }
    
    // Visuaçização de registros do sitema 
    public void showRegister(){
        System.out.println("Username: " + username + "\nEmail: " + email + "\nAge: " + age); 
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public String getCpf() {
        return cpf;
    }
}
