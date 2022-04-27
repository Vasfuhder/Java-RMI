import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIServer {
    public static void main(String[] args) {
        try {
            IQuestionario q = new Questionario();
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind(ServerEnum.serverName, q);
            System.out.println("Servidor pronto!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}