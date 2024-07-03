package conusltapi;

import java.util.ArrayList;
import java.util.List;

public class ListObserver implements Subject{
    List<Observer> observadores;
    private int promocao;

    public ListObserver() {
        this.observadores = new ArrayList<Observer>();
    }
    
    public void alterarDados(int promocao){
        this.promocao = promocao;
        notificaCliente();
    }

    @Override
    public void registrarCliente(String nameClient, String email){
        observadores.add(new Client(nameClient, email));
    }

    @Override
    public void removeCliente(int id) {
        if(id >= 0 && id < observadores.size()){
            observadores.remove(id);
            System.out.println("Cliente do ID " + (id + 1) + " removido com sucesso!");         }
    }

    @Override
    public void notificaCliente() {
        for (Observer o : observadores) {
            o.atualizar(promocao);
        }
    }
}
