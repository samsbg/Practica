package UnionFInd;

import java.util.Scanner;

public class ImpQuickUF {

	private int[] id;
	private int[] sz;

	public ImpQuickUF(int N) {
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
		int i = root(p);
		int j = root(q);
		if (i == j) return;
		if (sz[i] < sz[j]) {
			id[i] = j;
			sz[j] += sz[i];
		}
		else {
			id[j] = i;
			sz[i] += sz[j];
		}
	}
	
	public boolean connected(int p, int q) {
		return (root(p) == root(q));
	}
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		ImpQuickUF uf = new ImpQuickUF(N);
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
