import java.util.Scanner;

public class P7_5 {

	public static int SIZE = 4;

	public static void main (String[] args) {
	
		int[][] values = new int[SIZE][SIZE];
		
		Scanner scan = new Scanner (System.in);
	
		System.out.printf ("Enter %d values:%n", SIZE*SIZE);
		
		for (int i=0; i<SIZE; i++) for (int j=0; j<SIZE; j++) values[i][j] = scan.nextInt ();
		
				
		// validate
		num: for (int i=1; i <= SIZE*SIZE; i++) {
		
			for (int[] row : values) for (int val : row) if (val == i) continue num;
			
			System.err.printf ("Input does not include %d.%n", i);
			
			return;
		
		}
		
		// sums
		int[] sumsRow = new int[SIZE],
		      sumsCol = new int[SIZE];
		      
		int sumDiagFalling = 0, sumDiagRising = 0;
		
		for (int i=0; i<SIZE; i++) {
		
			sumDiagFalling += values[i][i];
			sumDiagRising += values[SIZE-1-i][i];
			
			for (int j=0; j<SIZE; j++) {
			
				sumsRow[i] += values[i][j];
				sumsCol[j] += values[i][j];
			}
			
		}
		
		// validate sums
		boolean good = true;
		
		for (int i : sumsRow) if (sumDiagFalling != i) good = false;
		for (int i : sumsCol) if (sumDiagFalling != i) good = false;
		
		if (sumDiagFalling != sumDiagRising) good = false;
		
		if (good) System.out.println ("This is a magic square.");
		else System.out.println ("This is not a magic square.");
		
	}

}