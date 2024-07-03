package conusltapi;

public interface Subject {
    public void registrarCliente(String nameClient, String email);
    public void removeCliente(int id);
    public void notificaCliente();
}
