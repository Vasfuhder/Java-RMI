import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server implements CounterServer {
    Server() throws RemoteException {}

    @Override
    public Counter createCounter(int initValue) throws RemoteException, AlreadyBoundException {
        Counter instance = (Counter) UnicastRemoteObject.exportObject(new CounterImp(initValue), 0);
        LocateRegistry.getRegistry().rebind("counter", instance);
        return instance;
    }

    public static void main(String[] args) {
        try {
            CounterServer server = new Server();
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind("counter_server", UnicastRemoteObject.exportObject(server, 0));
            System.out.println("Servidor pronto...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
