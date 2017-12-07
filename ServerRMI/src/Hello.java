import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Hello extends Remote{
	int[][] somaMat(int[][] a, int[][] b)throws RemoteException;
	int[][] transposta(int[][] a)throws RemoteException;
}
