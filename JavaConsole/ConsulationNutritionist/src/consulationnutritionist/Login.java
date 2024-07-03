package conusltapi;

public class Login {
    private String username;
    private String password;

    public Login() {
    }

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    // Verificando autenticação de usuário 
    public void authenticate(Register register){ 
        if(!this.username.equals(register.getUsername())){
            throw new BusineesException("Erro de NOME! Insira o nome correto!");
        } else if(!this.password.equals(register.getPassword())){
            throw new BusineesException("Erro de SENHA! Insira a senha correta!");
        }
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
