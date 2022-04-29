import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Counter extends Remote {
    // Retorna o valor atual do contador
    public int getValue() throws RemoteException;

    // Incrementa o contador e retorna seu novo valor
    public int nextValue() throws RemoteException;
}