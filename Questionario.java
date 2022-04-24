import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Questionario extends Remote {
    public String corrigir(String resposta) throws RemoteException;
}