package UnionFInd;

import java.util.Scanner;

public class QuickUF {
	
	private int[] id;

	public QuickUF(int N) {
		id = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
		}
	}

	private int root(int i) {
		while(i != id[i])
			i = id[i];
		return i;
	}
	
	public void union(int p, int q) {
		int i = id[p];
		int j = id[q];
		id[i] = j;
	}
	
	public boolean connected(int p, int q) {
		return (root(p) == root(q));
	}
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		QuickUF uf = new QuickUF(N);
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
