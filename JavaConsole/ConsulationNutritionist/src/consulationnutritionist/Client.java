package conusltapi;

public class Client implements InterfaceClient, Observer, Display{
    private String nameClient;
    private int ageClient;
    private String email;
    private String cpfClient;
    private String number;
    public int promocao;

    public Client() {
    }

    public Client(String nameClient, String email) {
        this.nameClient = nameClient;
        this.email = email;
    }
    
    public Client(String nameClient, int ageClient, String email, String cpfClient, String number) {
        this.nameClient = nameClient;
        this.ageClient = ageClient;
        this.email = email;
        this.cpfClient = cpfClient;
        this.number = number;
    }
    
    // Visualização do cliente do sistema 
    public void showClient(){
        System.out.println("Nome do Cliente: " + this.nameClient + " \nIdade: " + this.ageClient + " \nE-mail:" + 
                this.email + " \nCPF: " + this.cpfClient + 
                " \nNúmero: " + this.number); 
    }
    
    // Visualização do nome do cliente nas consultas já marcadas 
    @Override
    public void showNameClient() {
        System.out.println("|- Cliente: " + this.nameClient + " -|"); 
    }
    
    // Recebe uma nova porcentagem de desconto sempre que tiver 
    @Override
    public void atualizar(int promocao) {
        this.promocao = promocao;
        mostrarPromocao();
    }

    // Mostra mensagem para o cliente que tem uma consulta agenda ou um cliente que ja teve uma consulta 
    @Override
    public void mostrarPromocao() {
        System.out.println("Olá " + nameClient + " você recebeu uma nova 'PROMOÇÂO' de " + promocao + "% de 'DESCONTO'!");
    }
    
    public String getNameClient() {
        return nameClient;
    }

    public int getAgeClient() {
        return ageClient;
    }

    public String getCpfClient() {
        return cpfClient;
    }

    public String getNumber() {
        return number;
    }
}