import java.io.IOException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost");
            CounterServer server = (CounterServer) registry.lookup("counter_server");

            Counter c1 = (Counter) server.createCounter(0);
            Counter c2 = (Counter) server.createCounter(0);
            Counter c3 = (Counter) server.createCounter(0);

            Scanner in = new Scanner(System.in);
            int cmd = -1;
            while (cmd != 0) {
                clearConsole();
                System.out.println("Escolha o contador que deseja incrementar: ");
                System.out.println("1 - Contador 1: " + c1.getValue());
                System.out.println("2 - Contador 2: " + c2.getValue());
                System.out.println("3 - Contador 3: " + c3.getValue());
                System.out.println("0 - Sair");
                System.out.print("> ");
                cmd = in.nextInt();

                switch (cmd) {
                    case 1: c1.nextValue(); break;
                    case 2: c2.nextValue(); break;
                    case 3: c3.nextValue(); break;
                }

            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            else {
                System.out.print("\033\143");
            }
        } catch (IOException | InterruptedException ex) {}
    }
}
