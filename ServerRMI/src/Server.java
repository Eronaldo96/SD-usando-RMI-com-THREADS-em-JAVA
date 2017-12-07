import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

public class Server {
	
	public static void main(String args[]) {
		
		
		try {
			HelloImpl obj = new HelloImpl();
			
			Hello stub = (Hello) UnicastRemoteObject.exportObject(obj, 0);
			
			Registry registry = LocateRegistry.getRegistry();            
			
			registry.rebind("SomaDeMatrizesService", stub);
			
			System.err.println("Server ready");
			
		}catch(Exception e) {
			System.out.println("Serever exception:"+e.toString());
			
			e.printStackTrace();
		}
	}

}
