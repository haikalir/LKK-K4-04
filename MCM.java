public class MCM {
	
	static char matrix;
	
	static void matrixChainOrder(int arr[]) {
		
		int length = arr.length;
		int[][] total = new int[length][length];
		int[][] kArr = new int[length][length];
		for (int i = 1; i < length; i++) {
			
			total[i][i] = 0;
		}
		for (int l = 2; l < length; l++) {
			
			for (int i = 1; i < length - l + 1; i++) {
				
				int j = i + l - 1;
				total[i][j] = Integer.MAX_VALUE;
				
				for (int k = i; k <= j - 1; k++) {
					
					int q = total[i][k] + total[k + 1][j] + arr[i - 1] * arr[k] * arr[j];
					if (q < total[i][j]) {
						
						total[i][j] = q;
						kArr[i][j] = k;
					}
				}
			}
		}
		matrix = 'A';
		System.out.println("\nTabel Total");
		for (int i = 0; i < total.length; i++) {
			
			for (int j = 0; j < total.length; j++) {
			
				System.out.print(total[i][j] + "\t");
			}
			System.out.println("");
		}
		System.out.println("\nTabel K");
		for (int i = 0; i < kArr.length; i++) {
			
			for (int j = 0; j < kArr.length; j++) {
			
				System.out.print(kArr[i][j] + "\t");
			}
			System.out.println("");
		}
		System.out.println("");
		System.out.print("Kurung optimal: ");
		printParenthesis(1, length - 1, length, kArr);
		System.out.println();
		System.out.print("Harga termurah: " + total[1][length - 1]);
	}
	
	static void printParenthesis(int i, int j, int n, int[][] arr) {
		
		if (i == j) {
		    System.out.print(matrix++);
		    return;
		}
		System.out.print("(");
		printParenthesis(i, arr[i][j], n, arr);
		printParenthesis(arr[i][j] + 1, j, n, arr);
		System.out.print(")");
	}
	
	public static void main(String[] args) {
		
	}
}
