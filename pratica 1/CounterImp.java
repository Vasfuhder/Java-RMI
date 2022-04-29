import java.rmi.RemoteException;

public class CounterImp implements Counter {
    private int value = 0;
    
    CounterImp(int initValue) throws RemoteException {
        this.value = initValue;
    }

    @Override
    public int getValue() throws RemoteException {
        return value;
    }

    @Override
    public int nextValue() throws RemoteException {
        return this.value++;
    }
}
