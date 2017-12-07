import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client extends Thread{
	
	static Registry registry;
	static Hello stub;
	
	private int[][] matrizA, matrizB;
	
	private Client(int[][] matrizA, int[][] matrizB) {
		try {
			this.matrizA = matrizA;
			this.matrizB = matrizB;
			if(registry == null) {
				registry = LocateRegistry.getRegistry("localhost");
			}
			if(stub == null) {
				stub = (Hello) registry.lookup("SomaDeMatrizesService");
			}
		
		}catch (Exception e) {           
			System.err.println("Client exception: " + e.toString());
			e.printStackTrace(); 
		}
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			
			int[][] matriz;
			
			matriz = stub.somaMat(matrizA,matrizB);
			
			System.out.println("Matriz normal: ");
			
			for(int i = 0; i < matriz.length; i++) {
				for(int j = 0; j < matriz[0].length; j++) {
					System.out.print(matriz[i][j]+" ");
				
				}
				System.out.println( );
			}
			
			matriz = stub.transposta(matrizA);
		
			System.out.println("Matriz transposta:");
			
			for(int i = 0; i < matriz.length; i++) {
				for(int j = 0; j < matriz[0].length; j++) {
					System.out.print(matriz[i][j]+" ");
				
				}
				System.out.println( );
			}
		}catch (Exception e) {           
			
			System.err.println("Client exception: " + e.toString());
			
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		 int[][] a = {{3,2},{5,8}};
		 int[][] b = {{4,5},{10,9}};
		 int[][] c = {{10,6},{20,15}};
		 
		try {
			Client d = new Client(a,b);
			Client e = new Client(b,c);
			Client f = new Client(c,a);
			d.start();
			e.start();
			f.start();
		
		}catch (Exception e) {           
			System.err.println("Client exception: " + e.toString());
			e.printStackTrace(); 
		}
	}
}
