public class Intento {

	public static void main(String[] args) {
		
		int[] a = {1, 2, 3, 4, 5};
		
		ImprimirArreglo(a);
		numMax(a);
		reverso(a);

	}
	
	public static void ImprimirArreglo(int[] a) {
		System.out.println("Arreglo");
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println();
	}
	
	public static void numMax(int[] a) {
		System.out.println("Máximo");
		int max = a[0];
		for (int i = 1; i < a.length; i++)
			if (max < a[i])
				max = a[i];
		System.out.println(max);
	}
	
	public static void reverso(int[] a) {
		System.out.print("Reverso ");
		int temp;
		for (int i = 0; i < a.length/2; i++) {
			temp = a[i];
			a[i] = a[a.length - 1 - i];
			a[a.length - 1 - i] = temp;
		}
		ImprimirArreglo(a);
	}

}
