import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class RMIClient {
    public static void main(String[] args) {
        String host = "localhost";
        System.out.print("Insira a resposta: ");
        Scanner in = new Scanner(System.in);
        String resposta = in.nextLine();
        try {
            Registry registry = LocateRegistry.getRegistry(host);

            IQuestionario stub = (IQuestionario) registry.lookup(ServerEnum.serverName);

            String msg = stub.corrigir(resposta);
            System.out.println("Resposta do servidor: "+msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
        in.close();
    }
}
