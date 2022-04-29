import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IQuestionario extends Remote {
    public String corrigir(String resposta) throws RemoteException;
    public ArrayList<String> getQuestionario() throws RemoteException;
}