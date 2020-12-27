package UnionFInd;
import java.util.Scanner;

//Quick Find

// Hay n elementos en una lista con su indice, cuando se conectan dos elementos el indice de todos con el segundo indice cambian
// Inicialiar involucra hacer un arreglo de (1,...,n) por lo que la iniciación es O(n)
// El peor caso al conectar es que todos los demas (n-1) por lo que es O(n)
// Al checar si están conectados colo se necesita comparar los valores de los dos puntos, por lo que es O(1)

// Initialize O(n)
// Union O(n)
// Connected O(1)

public class UF {
	
	private int[] id;

	// Se inicializa el arreglo de n posiciones con indices
	// O(n)
	public UF(int N) {
		id = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
		}
	}
	
	// Al unir dos elementos, se cambian el index de todos los elementos que estan conectados a alguno
	// O(n)
	public void union(int p, int q) {
		int pid = id[p];
		int qid = id[q];
		for (int i = 0; i < id.length; i++) 
			if (id[i] == pid)
				id[i] = qid;
	}
	
	// Se compara el index de ambas posiciones, si son el mismo regresa verdadero
	// O(1)
	public boolean connected(int p, int q) {
		return (id[p] == id[q]);
	}
	
	// Comprueba su funcionamiento al definir cuantos elementos son y cuantas
	// uniones se quieren hacer
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int veces = scan.nextInt();
		UF uf = new UF(N);
		for (int i = 0; i < veces; i++) {
			int p = scan.nextInt();
			int q = scan.nextInt();
			if (!uf.connected(p,q)) {
				uf.union(p, q);
				System.out.println(p + " " + q);
			}
		}
		
		scan.close();
	}

}
