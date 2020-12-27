package UnionFInd;
import java.util.Scanner;

//Weighted quick union with path compression

// Hay n elementos en una lista con su indice, cuando se conectan dos elementos el indice del arbol más pequeño de uno, definido en otra lista) apunta al siguiente, creando arboles con ramas no tan alejadas de la raiz
// Inicializar involucra hacer un arreglo de (1,...,n) por lo que la iniciación es O(n)
// Al unir solo cambia un indice, pero para unir la cabeza con el arbol más pequeño se puede considerar los nodos modelados con la función de Ackerman anteriores O(A)
// Al checar si estan concetados se tienen que checar las cabezas, O(A)

// Initialize O(n)
// Union O(A)
// Connected O(A)

public class IWQuickUF {

    private int[] id;
    private int[] sz;

    // Se inicializa el arreglo de n posiciones con indices y otro de tamaño con 0s
    // O(n)
    public IWQuickUF(int N) {
		id = new int[N];
		sz = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
		}
	}

    // Se busca la cabeza del arbol
    // Si la posición y el index no son el mismo, va a la posición de la posición a
    // la que apunta y mueve el elemento un nivel para aplanar el árbol
    // O(1) -> O(A)
    private int root(int i) {
        while (i != id[i]);
            id[i] = id[id[i]];
            i = id[i];
        return i;
    }

    // Se buscan ambas cabezas y se conectan cuando la cabeza más pequeña apunta a
    // la otra
    // O(1), pero considerar la complejidad de root
    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        if (i == j)
            return;
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
    }

    // Se comparan las cabezas, si son las mismas regresa verdadero
    // O(1), pero considerar la complejidad de root
    public boolean connected(int p, int q) {
        return (root(p) == root(q));
    }
    
    // Comprueba su funcionamiento al definir cuantos elementos son y cuantas
    // uniones se quieren hacer
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        int veces = scan.nextInt();
        IWQuickUF uf = new IWQuickUF(N);
        for (int i = 0; i < veces; i++) {
            int p = scan.nextInt();
            int q = scan.nextInt();
            if (!uf.connected(p, q)) {
                uf.union(p, q);
                System.out.println(p + " " + q);
            }
        }

        scan.close();
    }
}
