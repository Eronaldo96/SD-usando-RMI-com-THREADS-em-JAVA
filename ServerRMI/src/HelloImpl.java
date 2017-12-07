
public class HelloImpl implements Hello{
		public HelloImpl() {
			super();
		}
		public int[][] somaMat(int[][] a, int[][] b) {
			int linhaA = a.length;
			int linhaB = b.length;
			int colunaA = a[0].length;
			int[][] soma = new int[linhaA][colunaA];
			
			
			
			if(linhaA != linhaB) {
				return null;
			}
			
			for(int i = 0; i < a.length; i++) {
				if(a[i].length != b[i].length ) {
					return null;
				}
				for (int j = 0; j < b.length; j++) {
					soma[i][j] = a[i][j] + b[i][j]; 
				}
			}
			return soma;
			
		}
		
		public int[][] transposta(int[][] a){
			int linhaA = a.length;
			int colunaA = a[0].length;
			int[][] nova = new int[colunaA][linhaA];  
			
			for(int i = 0; i < a.length; i++) {	
				for (int j = 0; j < a[0].length; j++) {
					nova[i][j] = a[j][i];
				}
			}
			return nova;
		}
	}


