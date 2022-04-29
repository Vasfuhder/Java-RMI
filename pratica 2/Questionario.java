import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Questionario extends UnicastRemoteObject implements IQuestionario {
    Questionario() throws RemoteException {
    }

    @Override
    public ArrayList<String> getQuestionario() throws RemoteException {
        ArrayList<String> q = new ArrayList<>();
        q.add("1;5;FFVFV");
        q.add("2;5;FVVFV");
        q.add("3;5;VFVFV");
        q.add("4;5;FFFFF");
        q.add("5;5;VVVFV");
        return q;
    }

    @Override
    public String corrigir(String resposta) throws RemoteException {
        ArrayList<String> questionario = this.getQuestionario();
        try {
            String[] res = resposta.split(";")[2].toLowerCase().split("");
            int n_res = Integer.parseInt(resposta.split(";")[0]) - 1;
            String[] qr = questionario.get(n_res).split(";")[2].toLowerCase().split("");

            // verificações
            for (String i : res)
                if (!i.equals("v") && !i.equals("f"))
                    throw new Exception();

            if (res.length != qr.length)
                throw new Exception("Quantidade de respostas para a questao informada\n" +
                        "e diferente do servidor. Qtde informada (" + res.length + "), qtde no servidor(" + qr.length
                        + ")");
            //

            int acertos = 0;
            for (int i = 0; i < qr.length; i++)
                if (qr[i].equals(res[i]))
                    acertos++;

            return resposta.split(";")[0] + ";" + String.valueOf(acertos) + ";" + String.valueOf(qr.length - acertos);
        } catch (Exception e) {
            String detalhe = "";
            if (e.getMessage() != null)
                detalhe = e.getMessage() + "\n";
            return detalhe + "Cliente enviou um formato de resposta inválido\n" +
                    "Insira <numero da questao>;<qtde_respostas>;<respostas (V ou F)>";
        }
    }
}