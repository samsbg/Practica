package UnionFInd;
import java.util.Scanner;

//Quick Find

// Hay n elementos en una 

// Initialize O(n)
// Union O(n)
// Connected O(1)

public class UF {
	
	private int[] id;

	public UF(int N) {
		id = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
		}
	}
	
	public void union(int p, int q) {
		int pid = id[p];
		int qid = id[q];
		for (int i = 0; i < id.length; i++) 
			if (id[i] == pid)
				id[i] = qid;
	}
	
	public boolean connected(int p, int q) {
		return (id[p] == id[q]);
	}
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		UF uf = new UF(N);
		while(scan.hasNextInt()) {
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
