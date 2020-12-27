package UnionFInd;
import java.util.Scanner;

//Quick union

// Hay n elementos en una lista con su indice, cuando se conectan dos elementos el indice de uno apunta al siguiente, creando arboles
// Inicializar involucra hacer un arreglo de (1,...,n) por lo que la iniciación es O(n)
// Al unir solo cambia un indice, pero para unir la cabeza se puede considerar n nodos anteriores O(n)
// Al checar si estan concetados se tienen que checar las cabezas, que puede requerir n nodos, O(n)

// Initialize O(n)
// Union O(n)
// Connected O(n)

public class QuickUF {
	
	private int[] id;

	// Se inicializa el arreglo de n posiciones con indices
	// O(n)
	public QuickUF(int N) {
		id = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
		}
	}

	// Se busca la cabeza del arbol
	// Si la posición y el index no son el mismo, va a la posición de la posición a la que apunta
	// O(1) -> O(n)
	private int root(int i) {
		while(i != id[i])
			i = id[i];
		return i;
	}
	
	// Se buscan ambas cabezas y se conectan cuando una apunta a la otra
	// O(1), pero considerar la complejidad de root
	public void union(int p, int q) {
		int i = root(p);
		int j = root(q);
		id[i] = j;
	}
	
	// Se comparan las cabezas, si son las mismas regresa verdadero
	// O(1), pero considerar la complejidad de root
	public boolean connected(int p, int q) {
		return (root(p) == root(q));
	}

	// Comprueba su funcionamiento al definir cuantos elementos son y cuantas uniones se quieren hacer
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int veces = scan.nextInt();
		QuickUF uf = new QuickUF(N);
		for (int i = 0; i < veces; i++) {
			int p = scan.nextInt();
			int q = scan.nextInt();
			if (!uf.connected(p,q)) {
				uf.union(p, q);
				System.out.println(p + " " + q);
			}
			else
				System.out.println("Ya están conectados");
		}
		
		scan.close();
	}
}
