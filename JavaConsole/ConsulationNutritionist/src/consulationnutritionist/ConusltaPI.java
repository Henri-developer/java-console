package conusltapi;

import java.util.Scanner;

public class ConusltaPI {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        /*
            Add Observer(está no Objeto ObserverConuslta). 
        */
        
        // Instancia de registro 
        Register register = new Register();
        
        // Instancia de Login
        Login login = new Login();
        
        // Instancia de lista de registro
        ListRegister listregister = new ListRegister();
        
        // Instanciando uma lista de profissional
        ListProfessional listProfessional = new ListProfessional();
        
        // Instanciando uma lista de cliente 
        ListClient listClient = new ListClient();
        
        // Instanciando uma lista(fila) de consulta 
        ListQuery listQuery = new ListQuery();
        
        // Instanciando uma lista de promocao 
        ListObserver promocao = new ListObserver();
        
        // Variáveis de registro do usuário
        String password = null;
        String email = null;
        String cpf = null;
        int age = 0;
        
        // Variáveis de login do usuário
        String name = null;
        String passwordL = null;
        
        // Começo do programa(cadastro)
        System.out.println("|- INFORME AO SEU CADASTRO AS SEGUINTES IMFORMAÇÕES: -|");
        System.out.println("");
        System.out.println("|Nome: ");
        String username = sc.nextLine();
        
        int n = 0;
        do{
            n = 0;
            System.out.println("|Senha: ");
            password = sc.next();

            try{
                register.checkPasswordLength(password);
                System.out.println("|E-mail: ");
                email = sc.next();
                System.out.println("|CPF: ");
                cpf = sc.next();
                System.out.println("|Idade: ");
                age = sc.nextInt();
                
                System.out.println("|- " + username + " cadastrado com sucesso! -|");
            } catch(BusineesException erro){
                n = 1;
                System.out.println(erro.getMessage()); 
            }
        }while(n == 1);
        
        // Instanciando um registro e add um novo registro 
        Register registers = new Register(username, password, email, cpf, age);
        listregister.addRegister(username, password, email, cpf, age); 
        
        System.out.println("");
        
        // Login
        System.out.println("|- INFORME AO SEU LOGIN AS SEGUINTES IMFORMAÇÕES: -|");
        System.out.println("");
        
        // Fazendo toda a parte de verificação(autenticação) 
        int nu = 0;
        do{
            nu = 0;
            System.out.println("|Nome: ");
            
            name = sc.next();
            
            System.out.println("|Senha: ");
            passwordL = sc.next();
            
            login.setUsername(name);
            login.setPassword(passwordL);
            
            try{
                login.authenticate(registers);
                System.out.println("|- Olá " + name + " redirecionando... -|");
            }catch(BusineesException erro){
                nu = 1;
                System.out.println(erro.getMessage());
            }
            
        } while(nu == 1); // Término da parte de verificação(autenticação) 
        
        System.out.println("");
        
        // Cadastro de profissionais ao sistema
        System.out.println("|- INFORME AS SEGUINTES IMFORMAÇÕES PARA ADICIONAR UM NOVO PROFISSINAL AO SISTEMA: -|");
        System.out.println("");
        
        String opc = null;
        do{
            System.out.println("|Nome: ");
            String nome = sc.next();
            
            System.out.println("|Especialidade: ");
            String especialidade = sc.next();
            
            listProfessional.addProfessional(nome, especialidade);
            
            System.out.println("|- DESEJA CADASTRAR MAIS ALGUM PROFISSIONAL AO SISTEMA(S/N): -| ");
            opc = sc.next();
        }while(opc.equalsIgnoreCase("S"));
        
        System.out.println("");
        
        System.out.println("|- LISTA ATUALIZADA -|");
        listProfessional.viewProfessional(); 
        // Fim do cadadastro de profissionais 
        
        System.out.println("|- DESEJA EXCLUIR ALGUM PROFISSIONAL DO SISTEMA(S/N): -|");
        String resp = sc.next();
        
        // Exclusão de profissionais 
        if(resp.equalsIgnoreCase("S")){
            int num = 0;
            do{
                try{
                    num = 0;
                    System.out.println("|- PROFISSIONAIS DISPONIVEIS -|");
                    listProfessional.viewProfessional();
                    
                    System.out.println("|Informe o número do profissional a ser excluido: ");
                    int id = sc.nextInt();
                    listProfessional.removeProfessional(id - 1);
                    
                    System.out.println("|- LISTA ATUALIZADA -|");
                    listProfessional.viewProfessional();
                }catch(BusineesException erro){
                    num = 1;
                    System.out.println("");
                    System.out.println(erro.getMessage());
                    System.out.println("");
                }
                
            }while(num == 1);
        } // Fim da exclusão do profissional 
        
        System.out.println("");
        
        // Cadastro de cliente 
        System.out.println("|- PARA PROSEGUIR A CONSULTA, FAÇA O CADASTRO DO CLIENTE ANTES: -| "
                + "\n|Informe o nome: ");
        String nameClient = sc.next();
        
        System.out.println("|Idade: ");
        int ageClient = sc.nextInt();
        
        System.out.println("|E-mail: ");
        String emailClient = sc.next();
        
        System.out.println("|CPF: ");
        String cpfClient = sc.next();
        
        System.out.println("|Número(telefone): ");
        String numberClient = sc.next();
        
        // Instancia de Client
        Client client = new Client(nameClient, ageClient, emailClient, cpfClient, numberClient);
        Client clientPromocao = new Client(nameClient, emailClient);
        
        // Add Client a lista 
        listClient.addClient(nameClient, ageClient, emailClient, cpfClient, numberClient);
        
        // Adicionando um cliente a lista de prmoção para ser notificado assim que sair uma nova promoção da clínica 
        promocao.registrarCliente(nameClient, email);
        
        System.out.println("");
        
        System.out.println("|- LISTA DE CLIENTES ATUALIZADA -|");
        listClient.viewClient(); 
        // Fim do cadastro de clientes
        System.out.println("");
        
        
        System.out.println("|- INFORME AS SEGUINTES IMFORMAÇÕES PARA UMA NOVA CONSULTA: -|");
        
        System.out.println("|Data(DD/MM/YYYY): ");
        String date = sc.next();
        
        System.out.println("|Horário: ");
        String hours = sc.next();
        System.out.println("");
        
        // Mostrando profissionais disponiveis
        listProfessional.viewProfessional();
        
        int nume = 0;
        do{
            try{
                nume = 0;
                System.out.println("Escolha o profissinal atrevés do ID: ");
                int id = sc.nextInt();
                
                // Add nome do profissional a consulta
                String nome = listProfessional.chooseID(id - 1);
                Query query = new Query(date, hours, nome, client);
                listQuery.addQuery(query);
                
                // Mostrando consultas marcadas 
                listQuery.viewQuery();
            } catch(BusineesException erro){
                nume = 1;
                System.out.println(erro.getMessage());
            }
        }while(nume == 1); 
        
        // Aplicando a promoção 
        promocao.alterarDados(50);
    }
}